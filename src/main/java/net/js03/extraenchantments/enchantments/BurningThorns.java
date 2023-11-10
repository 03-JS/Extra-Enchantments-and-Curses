package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class BurningThorns extends Enchantment {
    public BurningThorns(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.burningThorns.target(), slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 11 + 21 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 51;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.burningThorns.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Burning Thorns", stack, target);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.burningThorns.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.burningThorns.isAvailableForRandomSelection();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.THORNS;
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.burningThorns.isTreasure();
    }

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        int rng = (int) (1 + Math.random() * 4);
        if (attacker instanceof LivingEntity && rng <= level && !attacker.isOnFire()) {
            attacker.setOnFireFor(3);
        }
    }

}
