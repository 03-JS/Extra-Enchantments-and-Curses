package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.enchantments.Swiftness;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfAttrition extends Enchantment {
    public CurseOfAttrition(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEAPON, slotTypes);
    }

    @Override
    public int getMinCost(int pLevel) {
        return 25;
    }

    @Override
    public int getMaxCost(int pLevel) {
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
    public boolean canEnchant(ItemStack pStack) {
        return super.canEnchant(pStack) || pStack.getItem() instanceof PickaxeItem || pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof ShovelItem || pStack.getItem() instanceof HoeItem || pStack.getItem() instanceof TridentItem;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof Swiftness);
    }

    protected boolean canAccept(Enchantment other) {
        return !(other instanceof Swiftness) ;
    }
}
