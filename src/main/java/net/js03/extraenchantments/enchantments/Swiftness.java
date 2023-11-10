package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class Swiftness extends Enchantment {
    public Swiftness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.swiftness.target(), slotTypes);
    }

    public int getMinPower(int level) {
        return 1 + 10 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.swiftness.maxLevel();
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Swiftness", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.swiftness.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.swiftness.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.swiftness.isAvailableForRandomSelection();
    }
}
