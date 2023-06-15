package net.cpike.createcrypticaddons.event.loot;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.cpike.createcrypticaddons.entity.client.armor.NetheriteJetpackRenderer;
import net.cpike.createcrypticaddons.item.ModItems;
import net.cpike.createcrypticaddons.item.NetheriteJetpackItem;
import net.cpike.createcrypticaddons.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CreateCrypticAddons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event){
        GeoArmorRenderer.registerArmorRenderer(NetheriteJetpackItem.class, new NetheriteJetpackRenderer());
    }

}
