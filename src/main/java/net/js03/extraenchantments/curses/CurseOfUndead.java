package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class CurseOfUndead extends Enchantment {
    public CurseOfUndead(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfUndead.target(), slotTypes);
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
        return ExtraEnchantsMain.CONFIG.curseOfUndead.maxLevel();
    }

    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.curseOfUndead.isTreasure();
    }
}
