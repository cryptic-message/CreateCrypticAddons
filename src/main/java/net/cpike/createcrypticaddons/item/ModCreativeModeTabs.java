package net.cpike.createcrypticaddons.item;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateCrypticAddons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {

    public static final CreativeModeTab TAB_CRYPTICADDONS = new CreativeModeTab("createcrypticaddonstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NETHERITE_JETPACK.get());
        }
    };


}
