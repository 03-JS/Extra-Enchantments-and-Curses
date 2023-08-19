package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.world.dimension.DimensionType;

public class FreezingAspect extends Enchantment {
    public FreezingAspect(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
    }

//    @Override
//    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
//        if (target instanceof LivingEntity && !(target instanceof BlazeEntity) && !(target instanceof MagmaCubeEntity)) {
//            if (!user.getWorld().getDimension().ultrawarm() && !((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
//                target.setFrozenTicks(level * 360);
//            }
//        }
//    }
}
