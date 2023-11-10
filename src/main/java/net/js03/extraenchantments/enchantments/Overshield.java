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

;import java.util.ArrayList;
import java.util.List;

public class Overshield extends Enchantment {
    public Overshield(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.overshield.target(), slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1 + 8 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 30;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.overshield.maxLevel();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.overshield.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.overshield.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.overshield.isAvailableForRandomSelection();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Overshield", stack, target);
    }
}
