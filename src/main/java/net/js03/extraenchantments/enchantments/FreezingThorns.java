package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class FreezingThorns extends Enchantment {
    public FreezingThorns(Rarity weight, EquipmentSlot[] slotTypes) {
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
        return super.checkCompatibility(pOther) && pOther != Enchantments.THORNS && !(pOther instanceof BurningThorns);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        int rng = (int) (1 + Math.random() * 4);
        if (pAttacker instanceof LivingEntity && rng <= pLevel && !(pAttacker instanceof Blaze) && !(pAttacker instanceof MagmaCube)) {
            if (!pTarget.level().dimensionType().ultraWarm() && !pAttacker.isFullyFrozen() && !pAttacker.isInLava()) {
                pAttacker.setTicksFrozen(400);
            }
        }
    }
}
