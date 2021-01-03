
package net.mcreator.thestarwarssagamod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.procedures.CaptianrexsHelmetTickEventProcedure;
import net.mcreator.thestarwarssagamod.itemgroup.Legoin501ItemGroup;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Map;
import java.util.HashMap;

@TheStarWarsSagaModModElements.ModElement.Tag
public class CaptianrexsItem extends TheStarWarsSagaModModElements.ModElement {
	@ObjectHolder("the_star_wars_saga_mod:captianrexs_helmet")
	public static final Item helmet = null;
	@ObjectHolder("the_star_wars_saga_mod:captianrexs_chestplate")
	public static final Item body = null;
	@ObjectHolder("the_star_wars_saga_mod:captianrexs_leggings")
	public static final Item legs = null;
	@ObjectHolder("the_star_wars_saga_mod:captianrexs_boots")
	public static final Item boots = null;
	public CaptianrexsItem(TheStarWarsSagaModModElements instance) {
		super(instance, 133);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{10, 15, 20, 13}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "captianrexs";
			}

			public float getToughness() {
				return 1f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(Legoin501ItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_star_wars_saga_mod:textures/models/armor/rex__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					CaptianrexsHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("captianrexs_helmet"));
	}
}
