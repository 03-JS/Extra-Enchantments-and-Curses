package net.js03.extraenchantments.enchantments;


import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnigmaResonator extends Enchantment {
    public EnigmaResonator(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEAPON, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof PainCycle) && !(pOther instanceof HealthForBlood) && !(pOther instanceof Frenzy) && !(pOther instanceof GuardingStrike) && !(pOther instanceof SoulReaper);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return super.canEnchant(pStack) || pStack.getItem() instanceof AxeItem;
    }

//    @Override
//    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
//        if (pTarget instanceof LivingEntity && !((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
//            int rng = (int) (Math.random() * 35);
//            if (rng <= pLevel) {
//                if (((LivingEntity) pTarget).getLastDamageSource() != null) {
//                    pTarget.hurt(pTarget.damageSources().generic(), (float) (pAttacker.getHealth() * 0.75));
//                }
//            }
//        }
//    }
}
