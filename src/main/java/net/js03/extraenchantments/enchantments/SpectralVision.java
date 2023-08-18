package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.curses.CurseOfBlindness;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;


public class SpectralVision extends Enchantment {
    public SpectralVision(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_HEAD, slotTypes);
    }

    @Override
    public int getMinCost(int level) {
        return 1;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 40;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof CurseOfBlindness);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (pAttacker instanceof LivingEntity) {
            ((LivingEntity) pAttacker).addEffect(new MobEffectInstance(MobEffects.GLOWING, 320, 0, false, false, false));
        }
    }
}
