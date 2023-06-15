package net.cpike.createcrypticaddons.base;

import net.cpike.createcrypticaddons.CreateCrypticAddons;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record ModArmorTiers(String name, int durability, int[] protection, int enchantability, SoundEvent equip_sound,
                            float toughness, float knockback_resistance, Supplier<Ingredient> repair_material) implements ArmorMaterial
{
    private static final int[] DURABILITY_PER_SLOT = new int[] {13, 15, 16, 11};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_PER_SLOT[slot.getIndex()] * this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equip_sound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repair_material.get();
    }

    @Override
    public @NotNull String getName() {
        return CreateCrypticAddons.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockback_resistance;
    }
}
