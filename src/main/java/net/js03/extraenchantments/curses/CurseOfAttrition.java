package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.js03.extraenchantments.enchantments.Swiftness;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class CurseOfAttrition extends Enchantment {
    public CurseOfAttrition(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfAttrition.target(), slotTypes);
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
        return ExtraEnchantsMain.CONFIG.curseOfAttrition.isTreasure();
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.curseOfAttrition.maxLevel();
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Attrition Curse", stack, target);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof Swiftness) ;
    }
}
