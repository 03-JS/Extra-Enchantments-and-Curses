package net.js03.extraenchantments.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Swiftness extends Enchantment {
    public Swiftness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEAPON, slotTypes);
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
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof PickaxeItem || pStack.getItem() instanceof AxeItem || pStack.getItem() instanceof ShovelItem || pStack.getItem() instanceof HoeItem || super.canEnchant(pStack);
    }
}
