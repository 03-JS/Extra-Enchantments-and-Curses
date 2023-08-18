package net.js03.extraenchantments.enchantments;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ShadowShot extends Enchantment {
    public ShadowShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.BOW, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 30;
    }

    @Override
    public int getMaxCost(int level) {
        return 60;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof ElectrifyingShot) && !(pOther instanceof ResonatingShot) && pOther != Enchantments.QUICK_CHARGE && pOther != Enchantments.PIERCING && pOther != Enchantments.MULTISHOT && !(pOther instanceof HotShot) && !(pOther instanceof LevitationalShot) && !(pOther instanceof Supercharge);
    }

    /*@Override
    public boolean isTreasure() {
        return true;
    }*/

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity && pAttacker.level().isNight() && ((LivingEntity) pTarget).isDeadOrDying() && !pAttacker.level().isThundering()) {
            int rng = (int) (Math.random() * 15);
            if (rng <= 2) {
                if (((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
                    pAttacker.level().playSound(null, pAttacker.blockPosition(), SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.MASTER, 1f, 1f);
                    pAttacker.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 220, 254, false, false, true));
                    pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 254, false, false, true));
                }
            }
        }
    }
}
