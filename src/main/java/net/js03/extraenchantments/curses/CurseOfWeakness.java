package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;

public class CurseOfWeakness extends Enchantment {

    // private float previousHealth;

    public CurseOfWeakness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfWeakness.target(), slotTypes);
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
        return ExtraEnchantsMain.CONFIG.curseOfWeakness.maxLevel();
    }

    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.curseOfWeakness.isTreasure();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Weakness Curse", stack, target);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.curseOfWeakness.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.curseOfWeakness.isAvailableForRandomSelection();
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
