package net.js03.extraenchantments.enchantments;


import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class FreezingAspect extends Enchantment {
    public FreezingAspect(Rarity weight, EnchantmentCategory type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.FIRE_ASPECT;
    }

//    @Override
//    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
//        if (pTarget instanceof LivingEntity && !(pTarget instanceof Blaze) && !(pTarget instanceof MagmaCube)) {
//            if (!pAttacker.level().dimensionType().ultraWarm() && !((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
//                pTarget.setTicksFrozen(pLevel * 360);
//            }
//        }
//    }
}
