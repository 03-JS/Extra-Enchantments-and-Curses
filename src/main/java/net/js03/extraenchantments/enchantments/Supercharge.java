package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class Supercharge extends Enchantment {

    public Supercharge(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.CROSSBOW, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 20;
    }

    @Override
    public int getMaxCost(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return pOther != Enchantments.PIERCING && pOther != Enchantments.POWER_ARROWS && pOther != Enchantments.PUNCH_ARROWS;
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
