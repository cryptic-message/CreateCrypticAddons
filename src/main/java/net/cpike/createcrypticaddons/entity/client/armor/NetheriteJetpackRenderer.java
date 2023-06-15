package net.cpike.createcrypticaddons.entity.client.armor;

import net.cpike.createcrypticaddons.item.NetheriteJetpackItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class NetheriteJetpackRenderer extends GeoArmorRenderer<NetheriteJetpackItem> {
    public NetheriteJetpackRenderer() {
        super(new NetheriteJetpackModel());

        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";


        this.headBone = null;
        this.rightLegBone =null;
        this.leftLegBone =null;
        this.rightBootBone =null;
        this.leftBootBone =null;
    }

}
