package net.js03.extraenchantments.enchantments;


import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class LevitationalShot extends Enchantment {

    public LevitationalShot(Rarity weight, EnchantmentCategory type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
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
        return super.checkCompatibility(pOther) && pOther != Enchantments.QUICK_CHARGE && pOther != Enchantments.POWER_ARROWS && pOther != Enchantments.PUNCH_ARROWS && pOther != Enchantments.FLAMING_ARROWS && pOther != Enchantments.INFINITY_ARROWS && !(pOther instanceof ResonatingShot) && !(pOther instanceof ElectrifyingShot) && !(pOther instanceof ShadowShot);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (pTarget instanceof LivingEntity && ((LivingEntity) pTarget).getLastDamageSource() != null) {
            if (((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
                ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 2, 99, false, false, false));
            }
        }
    }
}
