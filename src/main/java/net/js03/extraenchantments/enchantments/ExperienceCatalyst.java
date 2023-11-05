package net.js03.extraenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ExperienceCatalyst extends Enchantment {
    public ExperienceCatalyst(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.FISHING_ROD, slotTypes);
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
        return pOther != Enchantments.MOB_LOOTING;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof SwordItem || pStack.getItem() instanceof PickaxeItem || pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof ShovelItem || pStack.getItem() instanceof HoeItem || pStack.getItem() instanceof TridentItem || super.canEnchant(pStack);
    }
}
