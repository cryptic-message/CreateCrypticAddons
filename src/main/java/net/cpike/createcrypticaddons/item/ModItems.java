package net.cpike.createcrypticaddons.item;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.cpike.createcrypticaddons.base.ModArmorTiers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateCrypticAddons.MOD_ID);

    // TO MAKE ANOTHER NEW ITEM, CREATE A NEW REGISTRY OBJECT INSTANCE, and change the name: string.
    // name must be lowercase no spaces
    //here
//    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
//            //()-> new ArmorItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)),
//            ()-> new ArmorItem(ArmorTiers.NETHERITEJETPACK, EquipmentSlot.CHEST,
//                    new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
//            )
//    );


    // to here
    // as well add to en_us.json file

    public static final RegistryObject<Item> NETHERITE_JETPACK = ITEMS.register("netherite_jetpack",
            ()-> new NetheriteJetpackItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTabs.TAB_CRYPTICADDONS).rarity(Rarity.EPIC).fireResistant()
            )
    );

    public static final RegistryObject<Item> NETHERITE_ENGINE = ITEMS.register("netherite_engine",
            ()-> new Item(new Item.Properties().tab(ModCreativeModeTabs.TAB_CRYPTICADDONS).stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static class ArmorTiers{
        public static final ArmorMaterial NETHERITEJETPACK = new ModArmorTiers(
                "netherite_jetpack",
                500,
                new int[] {3, 6, 8, 3},
                300,
                SoundEvents.ARMOR_EQUIP_NETHERITE,
                3.0f,
                1,
                () -> Ingredient.EMPTY
        );

    }

}

