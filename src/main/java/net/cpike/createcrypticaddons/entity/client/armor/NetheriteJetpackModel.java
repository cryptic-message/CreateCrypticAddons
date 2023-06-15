package net.cpike.createcrypticaddons.entity.client.armor;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.cpike.createcrypticaddons.item.NetheriteJetpackItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NetheriteJetpackModel extends AnimatedGeoModel<NetheriteJetpackItem>{
    @Override
    public ResourceLocation getModelResource(NetheriteJetpackItem object) {
        return new ResourceLocation(CreateCrypticAddons.MOD_ID, "geo/netherite_jetpack.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteJetpackItem object) {
        return new ResourceLocation(CreateCrypticAddons.MOD_ID, "textures/armor/netherite_jetpack_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteJetpackItem animatable) {
        return new ResourceLocation(CreateCrypticAddons.MOD_ID, "animations/netherite_jetpack.animation.json");
    }

}
