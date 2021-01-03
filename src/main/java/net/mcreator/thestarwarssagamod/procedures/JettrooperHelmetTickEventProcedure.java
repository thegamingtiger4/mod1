package net.mcreator.thestarwarssagamod.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Map;

@TheStarWarsSagaModModElements.ModElement.Tag
public class JettrooperHelmetTickEventProcedure extends TheStarWarsSagaModModElements.ModElement {
	public JettrooperHelmetTickEventProcedure(TheStarWarsSagaModModElements instance) {
		super(instance, 138);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JettrooperHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getFoodStats().setFoodLevel((int) 20);
	}
}
