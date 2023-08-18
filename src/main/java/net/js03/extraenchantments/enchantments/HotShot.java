package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class HotShot extends Enchantment {

    public HotShot(Rarity weight, EquipmentSlot[] slotTypes) {
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
        return 1;
    }

    /*
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
            if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
                target.setOnFireFor(5);
            }
        }
    }
    */
}
