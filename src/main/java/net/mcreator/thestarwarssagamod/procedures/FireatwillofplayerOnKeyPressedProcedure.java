package net.mcreator.thestarwarssagamod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.item.Ee11Item;
import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Random;
import java.util.Map;

@TheStarWarsSagaModModElements.ModElement.Tag
public class FireatwillofplayerOnKeyPressedProcedure extends TheStarWarsSagaModModElements.ModElement {
	public FireatwillofplayerOnKeyPressedProcedure(TheStarWarsSagaModModElements instance) {
		super(instance, 200);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure FireatwillofplayerOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FireatwillofplayerOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity.isPassenger())) {
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				Ee11Item.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 5, (int) 5);
			}
		}
	}
}
