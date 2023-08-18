package net.js03.extraenchantments.enchantments;


import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ElectrifyingShot extends Enchantment {
    public ElectrifyingShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.BOW, slotTypes);
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

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return pOther != Enchantments.QUICK_CHARGE && pOther != Enchantments.PIERCING && pOther != Enchantments.MULTISHOT && !(pOther instanceof HotShot) && !(pOther instanceof LevitationalShot) && !(pOther instanceof Supercharge);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        int rng = (int) (Math.random() * 11);
        if (pTarget instanceof LivingEntity && ((LivingEntity) pTarget).getLastDamageSource() != null) {
            if (((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE) && pAttacker.level().isThundering()) {
                if (rng <= 2) {
                    LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(pTarget.level());
                    assert lightningEntity != null;
                    lightningEntity.moveTo(pTarget.getX(), pTarget.getY(), pTarget.getZ());
                    pTarget.level().addFreshEntity(lightningEntity);
                }
            }
        }
    }
}
