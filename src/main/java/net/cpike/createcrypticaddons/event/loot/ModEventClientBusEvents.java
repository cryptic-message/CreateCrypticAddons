package net.cpike.createcrypticaddons.event.loot;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.cpike.createcrypticaddons.entity.client.armor.NetheriteJetpackRenderer;
import net.cpike.createcrypticaddons.item.NetheriteJetpackItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CreateCrypticAddons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value= Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event){
        GeoArmorRenderer.registerArmorRenderer(NetheriteJetpackItem.class, new NetheriteJetpackRenderer());
    }



}
