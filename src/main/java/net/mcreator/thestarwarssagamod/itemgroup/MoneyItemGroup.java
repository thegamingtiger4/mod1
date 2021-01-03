
package net.mcreator.thestarwarssagamod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thestarwarssagamod.item.Credits5Item;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class MoneyItemGroup extends TheStarWarsSagaModModElements.ModElement {
	public MoneyItemGroup(TheStarWarsSagaModModElements instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmoney") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Credits5Item.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
