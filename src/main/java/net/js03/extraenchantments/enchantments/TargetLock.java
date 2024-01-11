package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class TargetLock extends Enchantment {

    // private int arrows;
    // private int arrowThreshold;
    // private int hits;
    private float damage;
    private Entity previousTarget;
    // private Item previousItem;

    public TargetLock(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.targetLock.target(), slotTypes);
        // arrows = 1;
        // arrowThreshold = 3;
        // hits = 0;
        damage = 2;
        previousTarget = null;
        // previousItem = null;
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
        return ExtraEnchantsMain.CONFIG.targetLock.maxLevel();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.QUICK_CHARGE && (!(other instanceof Supercharge));
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.targetLock.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.targetLock.isTreasure();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Target Lock", stack, target);
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.targetLock.isAvailableForRandomSelection();
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && !ExtraEnchantsMain.CONFIG.targetLock.effectsDisabled()) {
            if (target.isAlive() && target == previousTarget && ((LivingEntity) target).getRecentDamageSource() != null) {
                if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
                    // arrows++;
                    if (/* arrows == arrowThreshold && */ ((LivingEntity) target).getRecentDamageSource() != null) {
                        target.damage(user.getDamageSources().indirectMagic(user, user), damage /* + Objects.requireNonNull(((LivingEntity) target).getDamageTracker().getMostRecentDamage()).getDamage()*/);
                        if (damage >= 32) {
                            if (target instanceof PlayerEntity) {
                                user.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.MASTER, 2f, 1f);
                            } else {
                                user.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f);
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
            previousTarget = target;
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
