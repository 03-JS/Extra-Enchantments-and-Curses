package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.curses.CurseOfBlindness;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

;

public class SpectralVision extends Enchantment {
    public SpectralVision(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_HEAD, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 40;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof CurseOfBlindness);
    }

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (attacker instanceof LivingEntity) {
            ((LivingEntity) attacker).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 320, 0, false, false, false));
        }
    }

}
