package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class ShadowShot extends Enchantment {
    public ShadowShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.BOW, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 30;
    }

    @Override
    public int getMaxPower(int level) {
        return 60;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof ElectrifyingShot) && !(other instanceof ResonatingShot) && other != Enchantments.QUICK_CHARGE && other != Enchantments.PIERCING && other != Enchantments.MULTISHOT && !(other instanceof HotShot) && !(other instanceof LevitationalShot) && !(other instanceof Supercharge);
    }

    /*@Override
    public boolean isTreasure() {
        return true;
    }*/

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && user.getWorld().isNight() && ((LivingEntity) target).isDead() && !user.getWorld().isThundering()) {
            int rng = (int) (Math.random() * 15);
            if (rng <= 2) {
                if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
                    user.getWorld().playSound(null, user.getBlockPos(), SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, SoundCategory.MASTER, 1f, 1f);
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 220, 254, false, false, true));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 220, 254, false, false, true));
                }
            }
        }
    }
}
