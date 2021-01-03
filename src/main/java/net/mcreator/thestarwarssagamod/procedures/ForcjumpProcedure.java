package net.mcreator.thestarwarssagamod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

import java.util.Map;

@TheStarWarsSagaModModElements.ModElement.Tag
public class ForcjumpProcedure extends TheStarWarsSagaModModElements.ModElement {
	public ForcjumpProcedure(TheStarWarsSagaModModElements instance) {
		super(instance, 170);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Forcjump!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 6e+23, (int) 10, (false), (false)));
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel(-((int) 30));
	}
}
