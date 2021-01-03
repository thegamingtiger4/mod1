
package net.mcreator.thestarwarssagamod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thestarwarssagamod.block.BasaltBlock;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class MustfarItemGroup extends TheStarWarsSagaModModElements.ModElement {
	public MustfarItemGroup(TheStarWarsSagaModModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmustfar") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BasaltBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
