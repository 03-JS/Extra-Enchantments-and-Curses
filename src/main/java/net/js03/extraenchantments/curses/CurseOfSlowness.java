package net.js03.extraenchantments.curses;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class CurseOfSlowness extends Enchantment {
    public CurseOfSlowness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_FEET, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 25;
    }

    @Override
    public int getMaxCost(int level) {
        return 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return pOther != Enchantments.SOUL_SPEED;
    }
}
