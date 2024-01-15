package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.js03.extraenchantments.enchantments.Swiftness;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class CurseOfFragility extends Enchantment {
    public CurseOfFragility(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfFragility.target(), slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.curseOfFragility.isTreasure();
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.curseOfFragility.maxLevel();
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Fragility Curse", stack, target);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.MENDING && other != Enchantments.UNBREAKING;
    }
}
