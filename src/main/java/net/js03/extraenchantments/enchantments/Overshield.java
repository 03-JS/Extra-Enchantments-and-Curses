package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Overshield extends Enchantment {
    public Overshield(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_CHEST, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 1 + 8 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 30;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }
}
