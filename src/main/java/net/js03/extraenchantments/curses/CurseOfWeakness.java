package net.js03.extraenchantments.curses;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfWeakness extends Enchantment {

    // private float previousHealth;

    public CurseOfWeakness(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEARABLE, slotTypes);
        // previousHealth = 0;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public int getMinCost(int level) {
        return 25;
    }

    public int getMaxCost(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    /*@Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && ((LivingEntity) target).getDamageTracker().getMostRecentDamage() != null) {
            if (((LivingEntity) target).getHealth() != previousHealth) {
                ((LivingEntity) target).heal(((LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage() / 2);
            } else {
                target.damage(DamageSource.GENERIC, 0.5F);
            }
            previousHealth = ((LivingEntity) target).getHealth();
        }
    }*/
}
