package net.cpike.createcrypticaddons.event;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.cpike.createcrypticaddons.item.ModItems;
import net.cpike.createcrypticaddons.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class clientEvents {


    @Mod.EventBusSubscriber(modid= CreateCrypticAddons.MOD_ID, value= Dist.CLIENT)
    public static class ClientForgeEvents{

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){

            if(KeyBinding.THRUSTING_KEY.isDown()) {

                LocalPlayer player = Minecraft.getInstance().player;
                Level level = (Level) player.getLevel();
                if(player.getItemBySlot(EquipmentSlot.CHEST).getItem() != ModItems.NETHERITE_JETPACK.get()) return;
                if(player.getItemBySlot(EquipmentSlot.CHEST).getTag().getInt("createcrypticaddons:fuel_stored") <= 0) return;

                Vec3 movement = player.getDeltaMovement();
                Vec3 angle = player.getLookAngle();

                boolean thrust = false;
                int i = 0;
                final int MAX_RANGE = 27;
                while(level.getBlockState(new BlockPos(player.getBlockX(), player.getBlockY()-i, player.getBlockZ())).getBlock()==Blocks.AIR){
                    if(i>MAX_RANGE) return;
                    i++;
                }
                if(i<=MAX_RANGE) thrust = true;

                final double Y_THRUST = !thrust ? 0.08 : movement.y+0.08f;
                final double Y_BREAKING = !thrust ? 0.08 : movement.y+0.12f;
                final double X_THRUST = KeyBinding.BOOSTING_KEY.isDown() ? Math.max(movement.x+0.05f, 0.7)*angle.x*Math.cos(angle.y) : movement.x;
                final double Z_THRUST = KeyBinding.BOOSTING_KEY.isDown() ? Math.max(movement.z+0.05f, 0.7)*angle.z*Math.cos(angle.y) : movement.z;

                // add to current velocity
                if(movement.y < 0){
                    player.setDeltaMovement(new Vec3(X_THRUST, Y_BREAKING, Z_THRUST));
                }
                else if (movement.y < 0.8) {
                    player.setDeltaMovement(new Vec3(X_THRUST, Y_THRUST, Z_THRUST));
                }

            }
        }
    }

    @Mod.EventBusSubscriber(modid= CreateCrypticAddons.MOD_ID, value= Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents{
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.THRUSTING_KEY);
            event.register(KeyBinding.BOOSTING_KEY);
        }

    }

}