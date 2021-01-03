
package net.mcreator.thestarwarssagamod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thestarwarssagamod.item.CaptianrexsItem;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class Legoin501ItemGroup extends TheStarWarsSagaModModElements.ModElement {
	public Legoin501ItemGroup(TheStarWarsSagaModModElements instance) {
		super(instance, 136);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablegoin_501") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CaptianrexsItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
