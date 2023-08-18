package net.js03.extraenchantments.enchantments;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class TargetLock extends Enchantment {

    // private int arrows;
    // private int arrowThreshold;
    // private int hits;
    private float damage;
    private Entity previousTarget;
    // private Item previousItem;

    public TargetLock(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.CROSSBOW, slotTypes);
        // arrows = 1;
        // arrowThreshold = 3;
        // hits = 0;
        damage = 2;
        previousTarget = null;
        // previousItem = null;
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
        return super.checkCompatibility(pOther) && pOther != Enchantments.QUICK_CHARGE && (!(pOther instanceof Supercharge));
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity) {
            if (pTarget.isAlive() && pTarget == previousTarget && ((LivingEntity) pTarget).getLastDamageSource() != null) {
                if (((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
                    // arrows++;
                    if (/* arrows == arrowThreshold && */ ((LivingEntity) pTarget).getLastDamageSource() != null) {
                        pTarget.hurt(pAttacker.damageSources().indirectMagic(pAttacker, pAttacker), damage /* + Objects.requireNonNull(((LivingEntity) target).getDamageTracker().getMostRecentDamage()).getDamage()*/);
                        if (damage >= 32) {
                            if (pTarget instanceof Player) {
                                pAttacker.level().playSound(null, pTarget.blockPosition(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.MASTER, 2f, 1f);
                            } else {
                                pAttacker.level().playSound(null, pTarget.blockPosition(), SoundEvents.ARROW_HIT_PLAYER, SoundSource.MASTER, 1f, 1f);
                            }
                        }
                        if (damage < 512) {
                            // arrowThreshold += 3;
                            damage *= 2;
                            // arrows = 0;
                        }
                    }
                }
            } else {
                // arrows = 1;
                // arrowThreshold = 3;
                damage = 2;
                // hits = 0;
            }
            previousTarget = pTarget;
            // previousItem = user.getActiveItem().getItem();
        }
    }

    /*
    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        hits++;
        if (hits == 3) {
            arrows = 0;
            arrowThreshold = 3;
            damage = 16;
            hits = 0;
        }
    }
*/

}
