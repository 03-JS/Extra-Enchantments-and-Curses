package net.js03.extraenchantments.enchantments;


import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ResonatingShot extends Enchantment {
    public ResonatingShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.BOW, slotTypes);
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
        return !(pOther instanceof ElectrifyingShot) && pOther != Enchantments.QUICK_CHARGE && pOther != Enchantments.PIERCING && pOther != Enchantments.MULTISHOT && !(pOther instanceof HotShot) && !(pOther instanceof LevitationalShot) && !(pOther instanceof Supercharge);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity) {
            int rng = (int) (Math.random() * 35);
            if (rng <= pLevel) {
                if (((LivingEntity) pTarget).getLastDamageSource() != null && ((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
                    pTarget.hurt(pAttacker.damageSources().generic(), (float) (pAttacker.getHealth() * 0.75) /* + ((LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage() */);
                }
            }
        }
    }
}
