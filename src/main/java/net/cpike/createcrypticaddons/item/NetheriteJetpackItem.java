package net.cpike.createcrypticaddons.item;

import com.google.common.collect.ImmutableMap;
import net.cpike.createcrypticaddons.util.KeyBinding;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.NoteBlockEvent;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;


import java.util.List;
import java.util.Map;

public class NetheriteJetpackItem extends GeoArmorItem implements IAnimatable {

    static final int MAX_FUEL = 1600*20;

    private void addNBTDataToNetheriteJetpack(ItemStack item, int fuel){

        int current_fuel = item.getTag().getInt("createcrypticaddons:fuel_stored");

        CompoundTag nbt_tag = new CompoundTag();
        nbt_tag.putInt("createcrypticaddons:fuel_stored", Math.min(current_fuel+fuel, MAX_FUEL));
        item.setTag(nbt_tag);
    }

    public void addFuel(ItemStack item, int fuel){
        addNBTDataToNetheriteJetpack(item, fuel);
    }

    @Override
    public void onArmorTick(ItemStack item, Level level, Player player) {
        super.onArmorTick(item, level, player);

        if(item.getTag().getInt("createcrypticaddons:fuel_stored")<=-100){
            addNBTDataToNetheriteJetpack(item, 200);
        }
        if(KeyBinding.THRUSTING_KEY.isDown()) {
            int fuel = item.getTag().getInt("createcrypticaddons:fuel_stored");

            //player.sendSystemMessage(Component.literal(""+fuel/20));
            // subtract fuel. if boosting, subtract 2, if not, subtract 1
            addFuel(item, !KeyBinding.BOOSTING_KEY.isDown()? -1 : -2);
        }

    }



    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()){
            if(itemStack.hasTag()){
            components.add(Component.literal("Fuel: ").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(""+(int)Math.floor(itemStack.getTag().getInt("createcrypticaddons:fuel_stored")/20))).withStyle(ChatFormatting.YELLOW)
                    .append(" / 1600").withStyle(ChatFormatting.GRAY)
            );
            }
            components.add(Component.literal("Hold [").withStyle(ChatFormatting.GRAY)
                    .append(Component.keybind("key.createcrypticaddons.jetpack_thrust")).withStyle(ChatFormatting.YELLOW)
                    .append("] to fly up!").withStyle(ChatFormatting.GRAY)
            );
            components.add(Component.literal("Hold [").withStyle(ChatFormatting.GRAY)
                    .append(Component.keybind("key.createcrypticaddons.jetpack_boost")).withStyle(ChatFormatting.YELLOW)
                    .append("] to fly forward!").withStyle(ChatFormatting.GRAY)
            );
        }
        else{
            components.add(Component.literal("Hold [SHIFT] for info").withStyle(ChatFormatting.DARK_GRAY));
        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public NetheriteJetpackItem(ArmorMaterial material, EquipmentSlot type, Properties properties) {
        super(material, type, properties);
    }

    public static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_MOB_EFFECT_INSTANCE_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.NETHERITEJETPACK, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1)).build();

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<NetheriteJetpackItem>(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.netherite_jetpack_cog", true));
        return PlayState.CONTINUE;
    }




}
