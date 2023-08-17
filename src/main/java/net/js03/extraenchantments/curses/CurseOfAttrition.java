package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.enchantments.Swiftness;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class CurseOfAttrition extends Enchantment {
    public CurseOfAttrition(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, slotTypes);
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
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof PickaxeItem || stack.getItem() instanceof AxeItem || stack.getItem() instanceof ShovelItem || stack.getItem() instanceof HoeItem || super.isAcceptableItem(stack);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof Swiftness) ;
    }
}
