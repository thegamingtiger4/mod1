package net.mcreator.thestarwarssagamod.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.item.Ee11Item;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Map;

@TheStarWarsSagaModModElements.ModElement.Tag
public class Clone501BootsTickEventProcedure extends TheStarWarsSagaModModElements.ModElement {
	public Clone501BootsTickEventProcedure(TheStarWarsSagaModModElements instance) {
		super(instance, 144);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Clone501BootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(Ee11Item.block, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}
