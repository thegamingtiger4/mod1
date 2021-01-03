
package net.mcreator.thestarwarssagamod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.thestarwarssagamod.item.Ee11Item;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TheStarWarsSagaModModElements.ModElement.Tag
public class SuperbattledroidEntity extends TheStarWarsSagaModModElements.ModElement {
	public static EntityType entity = null;
	public SuperbattledroidEntity(TheStarWarsSagaModModElements instance) {
		super(instance, 129);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("superbattledroid")
						.setRegistryName("superbattledroid");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("superbattledroid_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_modelb21(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("the_star_wars_saga_mod:textures/textureb2droid.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
			this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 1));
			this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.goalSelector.addGoal(9, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			Ee11Item.shoot(this, target);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_modelb21 extends EntityModel<Entity> {
		private final ModelRenderer leftleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer bone;
		private final ModelRenderer chest;
		private final ModelRenderer arm;
		private final ModelRenderer fist;
		private final ModelRenderer armright;
		private final ModelRenderer bone2;
		private final ModelRenderer bb_main;
		public Modelcustom_modelb21() {
			textureWidth = 16;
			textureHeight = 16;
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
			leftleg.setTextureOffset(0, 0).addBox(2.0F, -1.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
			leftleg.setTextureOffset(0, 0).addBox(3.0F, -21.0F, -1.0F, 3.0F, 21.0F, 3.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
			rightleg.setTextureOffset(0, 0).addBox(-5.0F, -21.0F, -1.0F, 3.0F, 21.0F, 3.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(chest);
			chest.setTextureOffset(0, 0).addBox(-5.0F, -24.0F, -1.0F, 11.0F, 3.0F, 3.0F, 0.0F, false);
			chest.setTextureOffset(0, 0).addBox(-5.0F, -26.0F, -2.0F, 11.0F, 3.0F, 5.0F, 0.0F, false);
			chest.setTextureOffset(0, 0).addBox(-6.0F, -42.0F, -3.0F, 13.0F, 16.0F, 6.0F, 0.0F, false);
			chest.setTextureOffset(0, 0).addBox(-2.0F, -43.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, false);
			chest.setTextureOffset(0, 0).addBox(-11.0F, -42.0F, -3.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);
			chest.setTextureOffset(0, 0).addBox(7.0F, -42.0F, -3.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);
			arm = new ModelRenderer(this);
			arm.setRotationPoint(-7.0F, 21.0F, -9.0F);
			setRotationAngle(arm, -0.2618F, 0.0F, 0.0F);
			arm.setTextureOffset(0, 0).addBox(-4.0F, -37.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			fist = new ModelRenderer(this);
			fist.setRotationPoint(0.0F, 6.0F, -27.0F);
			setRotationAngle(fist, -1.3526F, 0.0F, 0.0F);
			fist.setTextureOffset(0, 0).addBox(-11.0F, -28.0F, -5.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
			armright = new ModelRenderer(this);
			armright.setRotationPoint(0.0F, 24.0F, 0.0F);
			armright.setTextureOffset(0, 0).addBox(8.0F, -38.0F, -2.0F, 3.0F, 16.0F, 4.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(9.0F, -33.0F, 0.0F);
			armright.addChild(bone2);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 0).addBox(-10.0F, -28.0F, -15.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			arm.render(matrixStack, buffer, packedLight, packedOverlay);
			fist.render(matrixStack, buffer, packedLight, packedOverlay);
			armright.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
