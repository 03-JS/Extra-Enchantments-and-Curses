package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.curses.CurseOfZeus;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;


public class Electrified extends Enchantment {

    private int hitsTarget;
    private int hitsAttacker;

    public Electrified(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEARABLE, slotTypes);
        hitsTarget = 0;
        hitsAttacker = 0;
    }

    @Override
    public int getDamageProtection(int pLevel, DamageSource pSource) {
        return pSource.is(DamageTypeTags.IS_LIGHTNING) ? 4 : 0;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public int getMinCost(int level) {
        return 40;
    }

    @Override
    public int getMaxCost(int level) {
        return 70;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof CurseOfZeus);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        int rng = (int) (Math.random() * 11);
        if (pTarget instanceof LivingEntity) {
            if (pAttacker.level().isThundering()) {
                hitsAttacker++;
                if (rng <= 2 && hitsAttacker == 1) {
                    LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(pTarget.level());
                    assert lightningEntity != null;
                    lightningEntity.moveTo(pTarget.getX(), pTarget.getY(), pTarget.getZ());
                    pTarget.level().addFreshEntity(lightningEntity);
                }
                if (hitsAttacker == 4) {
                    hitsAttacker = 0;
                }
            }
        }
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        int rng = (int) (Math.random() * 11);
        if (pAttacker instanceof LivingEntity && ((LivingEntity) pAttacker).getLastDamageSource() != null) {
            if (pTarget.level().isThundering()) {
                hitsTarget++;
                if (rng <= 2 && hitsTarget == 1) {
                    LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(pAttacker.level());
                    assert lightningEntity != null;
                    lightningEntity.moveTo(pAttacker.getX(), pAttacker.getY(), pAttacker.getZ());
                    pAttacker.level().addFreshEntity(lightningEntity);
                }
                if (hitsTarget == 4) {
                    hitsTarget = 0;
                }
            }
        }
    }
}
