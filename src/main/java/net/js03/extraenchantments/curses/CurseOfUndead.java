package net.js03.extraenchantments.curses;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfUndead extends Enchantment {
    public CurseOfUndead(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_HEAD, slotTypes);
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

    public boolean isTreasureOnly() {
        return true;
    }
}
