package net.js03.extraenchantments.curses;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CurseOfUndead extends Enchantment {
    public CurseOfUndead(Rarity weight, EquipmentSlot[] slotTypes) {
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
}
