package net.fabricmc.extraenchantments.curses;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class CurseOfNausea extends Enchantment {
    public CurseOfNausea(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_HEAD, slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasure() {
        return true;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 320, 0, false, false, true));
    }
}
