
package net.mcreator.thestarwarssagamod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.thestarwarssagamod.itemgroup.Legoin501ItemGroup;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class AnkinslightsaberItem extends TheStarWarsSagaModModElements.ModElement {
	@ObjectHolder("the_star_wars_saga_mod:ankinslightsaber")
	public static final Item block = null;
	public AnkinslightsaberItem(TheStarWarsSagaModModElements instance) {
		super(instance, 145);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 11400;
			}

			public float getEfficiency() {
				return 5.5f;
			}

			public float getAttackDamage() {
				return 15.5f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -0.0000000000000004f, new Item.Properties().group(Legoin501ItemGroup.tab)) {
		}.setRegistryName("ankinslightsaber"));
	}
}
