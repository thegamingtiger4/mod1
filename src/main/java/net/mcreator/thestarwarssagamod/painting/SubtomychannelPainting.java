
package net.mcreator.thestarwarssagamod.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.thestarwarssagamod.TheStarWarsSagaModModElements;

@TheStarWarsSagaModModElements.ModElement.Tag
public class SubtomychannelPainting extends TheStarWarsSagaModModElements.ModElement {
	public SubtomychannelPainting(TheStarWarsSagaModModElements instance) {
		super(instance, 27);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(64, 64).setRegistryName("subtomychannel"));
	}
}
