package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.tag.DamageTypeTags;

public class Supercharge extends Enchantment {

    public Supercharge(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.CROSSBOW, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.PIERCING && other != Enchantments.POWER && other != Enchantments.PUNCH;
    }

//    @Override
//    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
//        if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
//            if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
//                if (((LivingEntity) target).getRecentDamageSource() != null) {
//                    target.damage(user.getDamageSources().generic(), (/* (LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage() + 2 */ 5 * level));
//                }
//                for (int i = 0; i < level * 2; i++) {
//                    target.pushAwayFrom(user);
//                }
//            }
//        }
//    }
}
