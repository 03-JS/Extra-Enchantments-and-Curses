package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class ExperienceCatalyst extends Enchantment{

    public ExperienceCatalyst(Enchantment.Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.FISHING_ROD, slotTypes);
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

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof PickaxeItem || stack.getItem() instanceof AxeItem || stack.getItem() instanceof ShovelItem || stack.getItem() instanceof HoeItem || stack.getItem() instanceof TridentItem || super.isAcceptableItem(stack);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) || other != Enchantments.LOOTING || other != Enchantments.FORTUNE;
    }
}
