package net.js03.extraenchantments.curses;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfIncompatibility extends Enchantment {
    public CurseOfIncompatibility(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.BREAKABLE, slotTypes);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public int getMinCost(int level) {
        return 25;
    }

    public int getMaxCost(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return false;
    }

    public boolean isTreasureOnly() {
        return true;
    }
}
