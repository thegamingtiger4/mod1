
package net.mcreator.thestarwarssagamod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.thestarwarssagamod.itemgroup.MoneyItemGroup;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.List;
import java.util.Collections;

@TheStarWarsSagaModModElements.ModElement.Tag
public class ShrubLeavesBlock extends TheStarWarsSagaModModElements.ModElement {
	@ObjectHolder("the_star_wars_saga_mod:shrub_leaves")
	public static final Block block = null;
	public ShrubLeavesBlock(TheStarWarsSagaModModElements instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MoneyItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends LeavesBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).lightValue(0).notSolid());
			setRegistryName("shrub_leaves");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
