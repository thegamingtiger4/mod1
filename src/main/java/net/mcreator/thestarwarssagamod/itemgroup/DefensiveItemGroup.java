
package net.mcreator.thestarwarssagamod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.thestarwarssagamod.block.SANDBAGBlock;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class DefensiveItemGroup extends TheStarWarsSagaModModElements.ModElement {
	public DefensiveItemGroup(TheStarWarsSagaModModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdefensive") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SANDBAGBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
