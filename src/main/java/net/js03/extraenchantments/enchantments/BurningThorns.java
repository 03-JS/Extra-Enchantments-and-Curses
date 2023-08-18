package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

;

public class BurningThorns extends Enchantment {
    public BurningThorns(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_CHEST, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 11 + 21 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 51;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return super.canEnchant(pStack) || pStack.getItem() instanceof ArmorItem;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.THORNS;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        int rng = (int) (1 + Math.random() * 4);
        if (pAttacker instanceof LivingEntity && rng <= pLevel) {
            pAttacker.setSecondsOnFire(3);
        }
    }
}
