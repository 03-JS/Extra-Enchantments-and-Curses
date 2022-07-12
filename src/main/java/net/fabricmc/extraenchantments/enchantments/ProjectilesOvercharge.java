package net.fabricmc.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Objects;

public class ProjectilesOvercharge extends Enchantment {

    private int arrows;
    private int arrowThreshold;
    private int hits;
    private float damage;
    private Entity previousTarget;

    public ProjectilesOvercharge(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_LEGS, slotTypes);
        arrows = 1;
        arrowThreshold = 3;
        hits = 0;
        damage = 16;
        previousTarget = null;
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
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.MENDING;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            if (target.isAlive() && target == previousTarget && ((LivingEntity) target).getRecentDamageSource() != null) {
                if (((LivingEntity) target).getRecentDamageSource().isProjectile()) {
                    arrows++;
                    if (arrows == arrowThreshold && ((LivingEntity) target).getDamageTracker().getMostRecentDamage() != null) {
                        target.damage(DamageSource.MAGIC.setProjectile(), damage + Objects.requireNonNull(((LivingEntity) target).getDamageTracker().getMostRecentDamage()).getDamage());
                        if (target instanceof PlayerEntity) {
                            user.world.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.MASTER, 2f, 1f);
                        } else {
                            user.world.playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f);
                        }
                        arrowThreshold += 3;
                        damage *= 2;
                        arrows = 0;
                    }
                }
            } else {
                arrows = 1;
                arrowThreshold = 3;
                damage = 16;
                hits = 0;
            }
            previousTarget = target;
        }
    }

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
}
