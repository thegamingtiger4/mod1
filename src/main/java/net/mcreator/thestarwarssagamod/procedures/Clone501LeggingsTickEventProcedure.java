package net.mcreator.thestarwarssagamod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Map;

@TheStarWarsSagaModModElements.ModElement.Tag
public class Clone501LeggingsTickEventProcedure extends TheStarWarsSagaModModElements.ModElement {
	public Clone501LeggingsTickEventProcedure(TheStarWarsSagaModModElements instance) {
		super(instance, 143);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Clone501LeggingsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60, (int) 1, (false), (false)));
	}
}
