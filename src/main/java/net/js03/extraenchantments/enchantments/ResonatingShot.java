package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.DamageTypeTags;

public class ResonatingShot extends Enchantment {
    public ResonatingShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.BOW, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof ElectrifyingShot) && other != Enchantments.QUICK_CHARGE && other != Enchantments.PIERCING && other != Enchantments.MULTISHOT && !(other instanceof HotShot) && !(other instanceof LevitationalShot) && !(other instanceof Supercharge);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            int rng = (int) (Math.random() * 35);
            if (rng <= level) {
                if (((LivingEntity) target).getRecentDamageSource() != null && ((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
                    target.damage(user.getDamageSources().generic(), (float) (user.getHealth() * 0.75) /* + ((LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage() */);
                }
            }
        }
    }
}
