
package net.mcreator.thestarwarssagamod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TheStarWarsSagaModModElements.ModElement.Tag
public class Ttank1Entity extends TheStarWarsSagaModModElements.ModElement {
	public static EntityType entity = null;
	public Ttank1Entity(TheStarWarsSagaModModElements instance) {
		super(instance, 199);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("ttank_1")
						.setRegistryName("ttank_1");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("ttank_1_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltank(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("the_star_wars_saga_mod:textures/vechclietank_tyank_tank_tank_tank.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound(
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_star_wars_saga_mod:speeder")),
					0.15f, 1);
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			super.processInteract(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}

		@Override
		public void travel(Vec3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vec3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.2999999985098839D;
					double d4 = (random.nextFloat() - 0.5D) * 0.2999999985098839D;
					double d5 = (random.nextFloat() - 0.5D) * 0.2999999985098839D;
					world.addParticle(ParticleTypes.LARGE_SMOKE, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modeltank extends EntityModel<Entity> {
		private final ModelRenderer tank;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		public Modeltank() {
			textureWidth = 512;
			textureHeight = 512;
			tank = new ModelRenderer(this);
			tank.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			tank.addChild(body);
			body.setTextureOffset(172, 0).addBox(-11.0F, -19.0F, -8.0F, 22.0F, 19.0F, 16.0F, 0.0F, false);
			body.setTextureOffset(172, 35).addBox(-15.0F, -26.0F, -5.0F, 30.0F, 1.0F, 15.0F, 0.0F, false);
			body.setTextureOffset(0, 76).addBox(11.0F, -10.0F, -29.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
			body.setTextureOffset(0, 36).addBox(-15.0F, -10.0F, -29.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
			body.setTextureOffset(146, 162).addBox(-11.0F, -10.0F, -29.0F, 22.0F, 10.0F, 30.0F, 0.0F, false);
			body.setTextureOffset(0, 108).addBox(10.0F, -22.0F, -7.0F, 5.0F, 7.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(109, 6).addBox(10.0F, -24.0F, -6.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(26, 109).addBox(10.0F, -25.0F, -5.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(86, 6).addBox(-15.0F, -25.0F, -5.0F, 5.0F, 3.0F, 13.0F, 0.0F, false);
			body.setTextureOffset(30, 76).addBox(-15.0F, -23.0F, -6.0F, 5.0F, 3.0F, 14.0F, 0.0F, false);
			body.setTextureOffset(30, 36).addBox(-15.0F, -22.0F, -7.0F, 5.0F, 7.0F, 15.0F, 0.0F, false);
			body.setTextureOffset(0, 36).addBox(-11.0F, -25.0F, 0.0F, 1.0F, 6.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(104, 39).addBox(10.0F, -25.0F, 0.0F, 5.0F, 10.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(103, 94).addBox(-18.0F, -15.0F, -2.0F, 7.0F, 3.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(0, 50).addBox(11.0F, -15.0F, -2.0F, 7.0F, 3.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(86, 86).addBox(-15.0F, -25.0F, 8.0F, 30.0F, 7.0F, 1.0F, 0.0F, false);
			body.setTextureOffset(86, 6).addBox(-18.0F, -6.0F, -61.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);
			body.setTextureOffset(86, 86).addBox(9.0F, -6.0F, -61.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(13.0F, -1.0F, -26.0F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.6109F);
			cube_r1.setTextureOffset(0, 76).addBox(-1.0F, -5.0F, -40.0F, 4.0F, 6.0F, 5.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-16.0F, -2.0F, -26.0F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6109F);
			cube_r2.setTextureOffset(0, 87).addBox(-1.0F, -5.0F, -40.0F, 4.0F, 6.0F, 5.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-14.0F, -26.0F, 9.0F);
			body.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -0.3054F, 0.0F);
			cube_r3.setTextureOffset(18, 36).addBox(-1.0F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(12.0F, -6.0F, 0.0F);
			body.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.2182F);
			cube_r4.setTextureOffset(0, 152).addBox(-3.0F, -2.0F, -61.0F, 8.0F, 3.0F, 57.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-15.0F, -6.0F, 0.0F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -0.2182F);
			cube_r5.setTextureOffset(73, 162).addBox(-3.0F, -2.0F, -61.0F, 8.0F, 3.0F, 57.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(23.0F, 2.0F, 1.0F);
			body.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, 0.1745F);
			cube_r6.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -62.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-18.0F, 0.0F, 1.0F);
			body.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, -0.1745F);
			cube_r7.setTextureOffset(0, 76).addBox(-7.0F, -6.0F, -62.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-18.0F, -12.0F, -1.0F);
			body.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.1745F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(41, 58).addBox(-1.0F, -1.0F, -10.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
			cube_r8.setTextureOffset(101, 107).addBox(36.0F, -1.0F, -10.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-18.0F, -14.0F, -1.0F);
			body.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.1745F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(86, 47).addBox(-1.0F, -1.0F, -13.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			cube_r9.setTextureOffset(38, 94).addBox(36.0F, -1.0F, -13.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(22.0F, 4.0F, -10.0F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.829F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(86, 94).addBox(-11.0F, -19.0F, -15.0F, 4.0F, 15.0F, 9.0F, 0.0F, false);
			cube_r10.setTextureOffset(86, 22).addBox(-37.0F, -19.0F, -15.0F, 4.0F, 16.0F, 9.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 1.0F, -15.0F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.1345F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 0).addBox(-11.0F, -19.0F, -15.0F, 22.0F, 27.0F, 9.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(11.0F, -20.0F, -8.0F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.5236F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(0, 0).addBox(-12.0F, -6.0F, 0.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(13.0F, -20.0F, -7.0F);
			body.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.5236F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(86, 62).addBox(-12.0F, -4.0F, -1.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r13.setTextureOffset(103, 22).addBox(-28.0F, -4.0F, -1.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-1.0F, -24.0F, -6.0F);
			body.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.5236F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(86, 0).addBox(-14.0F, -2.0F, 0.0F, 30.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-1.0F, -19.0F, -8.0F);
			body.addChild(cube_r15);
			setRotationAngle(cube_r15, -0.5236F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(86, 3).addBox(-14.0F, -2.0F, 0.0F, 30.0F, 2.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			tank.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
