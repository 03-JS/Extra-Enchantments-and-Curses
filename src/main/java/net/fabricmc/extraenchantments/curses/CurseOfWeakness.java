package net.fabricmc.extraenchantments.curses;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class CurseOfWeakness extends Enchantment {

    // private float previousHealth;

    public CurseOfWeakness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.WEARABLE, slotTypes);
        // previousHealth = 0;
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

    /*@Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && ((LivingEntity) target).getDamageTracker().getMostRecentDamage() != null) {
            if (((LivingEntity) target).getHealth() != previousHealth) {
                ((LivingEntity) target).heal(((LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage() / 2);
            } else {
                target.damage(DamageSource.GENERIC, 0.5F);
            }
            previousHealth = ((LivingEntity) target).getHealth();
        }
    }*/
}
