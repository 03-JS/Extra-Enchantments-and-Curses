package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;

public class Reach extends Enchantment {
    public Reach(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.DIGGER, slotTypes);
    }

    public int getMinPower(int level) {
        return 1 + 10 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof Swiftness);
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof ShearsItem || stack.getItem() instanceof TridentItem || super.isAcceptableItem(stack);
    }
}
