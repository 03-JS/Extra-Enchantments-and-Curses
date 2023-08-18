package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Reach extends Enchantment {
    public Reach(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.DIGGER, slotTypes);
    }

    public int getMinCost(int level) {
        return 1 + 10 * (level - 1);
    }

    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof Swiftness);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof ShearsItem || super.canEnchant(pStack);
    }
}
