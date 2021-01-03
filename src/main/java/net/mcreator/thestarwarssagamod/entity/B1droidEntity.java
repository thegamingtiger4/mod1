
package net.mcreator.thestarwarssagamod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.thestarwarssagamod.gui.DroidtamedGui;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TheStarWarsSagaModModElements.ModElement.Tag
public class B1droidEntity extends TheStarWarsSagaModModElements.ModElement {
	public static EntityType entity = null;
	public B1droidEntity(TheStarWarsSagaModModElements instance) {
		super(instance, 132);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("b_1droid")
						.setRegistryName("b_1droid");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("b_1droid_spawn_egg"));
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
			return new MobRenderer(renderManager, new Modelcustom_modeldroid(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("the_star_wars_saga_mod:textures/texture_droid_reg.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
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
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, JarjarbinksEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, WookieEntity.CustomEntity.class, false, false));
			this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, B1droidEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(12, new BreakDoorGoal(this, e -> true));
			this.goalSelector.addGoal(13, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(14, new LookAtGoal(this, SuperbattledroidEntity.CustomEntity.class, (float) 6));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}
		private final ItemStackHandler inventory = new ItemStackHandler(3) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}
		};
		private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this),
				new EntityArmorInvWrapper(this));
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
			if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == null)
				return LazyOptional.of(() -> combined).cast();
			return super.getCapability(capability, side);
		}

		@Override
		protected void dropInventory() {
			super.dropInventory();
			for (int i = 0; i < inventory.getSlots(); ++i) {
				ItemStack itemstack = inventory.getStackInSlot(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.entityDropItem(itemstack);
				}
			}
		}

		@Override
		public void writeAdditional(CompoundNBT compound) {
			super.writeAdditional(compound);
			compound.put("InventoryCustom", inventory.serializeNBT());
		}

		@Override
		public void readAdditional(CompoundNBT compound) {
			super.readAdditional(compound);
			INBT inventoryCustom = compound.get("InventoryCustom");
			if (inventoryCustom instanceof CompoundNBT)
				inventory.deserializeNBT((CompoundNBT) inventoryCustom);
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			if (sourceentity instanceof ServerPlayerEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) sourceentity, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("B-1droid");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
						packetBuffer.writeBlockPos(new BlockPos(sourceentity));
						packetBuffer.writeByte(0);
						packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
						return new DroidtamedGui.GuiContainerMod(id, inventory, packetBuffer);
					}
				}, buf -> {
					buf.writeBlockPos(new BlockPos(sourceentity));
					buf.writeByte(0);
					buf.writeVarInt(this.getEntityId());
				});
			}
			super.processInteract(sourceentity, hand);
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_modeldroid extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer rightleg;
		private final ModelRenderer bone;
		private final ModelRenderer leftleg;
		private final ModelRenderer bone2;
		private final ModelRenderer chest;
		private final ModelRenderer slants;
		private final ModelRenderer slants2;
		private final ModelRenderer head;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone11;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		public Modelcustom_modeldroid() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(rightleg);
			rightleg.setTextureOffset(45, 14).addBox(-5.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
			rightleg.setTextureOffset(40, 6).addBox(-5.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 0.0F, -3.0F);
			rightleg.addChild(bone);
			setRotationAngle(bone, -0.3054F, 0.0F, 0.0F);
			bone.setTextureOffset(42, 29).addBox(-5.0F, -16.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(leftleg);
			leftleg.setTextureOffset(44, 38).addBox(3.0F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
			leftleg.setTextureOffset(16, 40).addBox(3.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, -3.0F);
			leftleg.addChild(bone2);
			setRotationAngle(bone2, -0.3054F, 0.0F, 0.0F);
			bone2.setTextureOffset(24, 42).addBox(3.0F, -16.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
			chest = new ModelRenderer(this);
			chest.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(chest);
			chest.setTextureOffset(24, 24).addBox(-5.0F, -17.0F, 1.0F, 10.0F, 3.0F, 2.0F, 0.0F, false);
			chest.setTextureOffset(0, 4).addBox(-5.0F, -34.0F, 0.0F, 10.0F, 10.0F, 4.0F, 0.0F, false);
			chest.setTextureOffset(24, 4).addBox(-5.0F, -20.0F, 1.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
			chest.setTextureOffset(0, 18).addBox(-4.0F, -35.0F, 0.0F, 8.0F, 5.0F, 4.0F, 0.0F, false);
			chest.setTextureOffset(26, 29).addBox(1.0F, -34.0F, 4.0F, 3.0F, 11.0F, 2.0F, 0.0F, false);
			chest.setTextureOffset(16, 27).addBox(-4.0F, -34.0F, 4.0F, 3.0F, 11.0F, 2.0F, 0.0F, false);
			slants = new ModelRenderer(this);
			slants.setRotationPoint(0.0F, 0.0F, 0.0F);
			chest.addChild(slants);
			setRotationAngle(slants, -0.0873F, 0.0F, 0.0F);
			slants.setTextureOffset(6, 46).addBox(-5.0F, -27.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			slants2 = new ModelRenderer(this);
			slants2.setRotationPoint(9.0F, 0.0F, 0.0F);
			chest.addChild(slants2);
			setRotationAngle(slants2, -0.0873F, 0.0F, 0.0F);
			slants2.setTextureOffset(32, 45).addBox(-5.0F, -27.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			slants2.setTextureOffset(0, 35).addBox(-10.0F, -27.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(head);
			head.setTextureOffset(48, 26).addBox(-1.0F, -43.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 0.0F, -9.0F);
			head.addChild(bone3);
			setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
			bone3.setTextureOffset(46, 0).addBox(-1.0F, -42.0F, 0.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, -39.0F, 0.0F);
			head.addChild(bone4);
			setRotationAngle(bone4, 0.2182F, 0.0F, 0.0F);
			bone4.setTextureOffset(21, 11).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 7.0F, 0.0F, false);
			bone4.setTextureOffset(0, 27).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			bone4.setTextureOffset(47, 18).addBox(-1.0F, -3.0F, 3.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, -40.0F, 7.0F);
			head.addChild(bone5);
			setRotationAngle(bone5, 0.2182F, 0.0F, 0.0F);
			bone5.setTextureOffset(0, 27).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(28, 5).addBox(1.0F, -5.6493F, -3.9289F, 0.0F, 5.0F, 1.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, -6.0F, -27.0F);
			head.addChild(bone11);
			setRotationAngle(bone11, -0.6981F, 0.0F, 0.0F);
			bone11.setTextureOffset(32, 21).addBox(-1.0F, -42.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-7.0F, -33.0F, 0.0F);
			body.addChild(bone6);
			bone6.setTextureOffset(46, 23).addBox(0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			bone6.setTextureOffset(24, 21).addBox(11.0F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, -2.0F, 1.0F);
			bone6.addChild(bone7);
			setRotationAngle(bone7, -0.3927F, 0.0F, 0.0F);
			bone7.setTextureOffset(36, 36).addBox(-1.0F, 0.0F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			bone7.setTextureOffset(8, 35).addBox(14.0F, 0.0F, 1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 7.0F, -1.0F);
			bone6.addChild(bone8);
			setRotationAngle(bone8, -0.829F, -0.7418F, 0.0F);
			bone8.setTextureOffset(44, 44).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(14.0F, 8.0F, -1.0F);
			bone6.addChild(bone9);
			setRotationAngle(bone9, -1.0036F, 1.0908F, 0.0F);
			bone9.setTextureOffset(32, 6).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(5.0F, 10.0F, -9.0F);
			bone6.addChild(bone10);
			setRotationAngle(bone10, -0.2182F, 0.48F, 0.48F);
			bone10.setTextureOffset(0, 0).addBox(-7.0F, -1.0F, 4.0F, 18.0F, 2.0F, 2.0F, 0.0F, false);
			bone10.setTextureOffset(39, 17).addBox(-7.0F, -1.0F, 4.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			bone10.setTextureOffset(48, 8).addBox(-5.1153F, 0.3865F, 3.7965F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone10.setTextureOffset(36, 29).addBox(-1.1565F, 0.8836F, 3.7984F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			bone10.setTextureOffset(10, 27).addBox(-0.3697F, 0.3441F, 4.0983F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
