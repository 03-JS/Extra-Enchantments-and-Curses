package net.js03.extraenchantments.curses;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfWithering extends Enchantment {
    public CurseOfWithering(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEARABLE, slotTypes);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public int getMinCost(int level) {
        return 25;
    }

    public int getMaxCost(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.WITHER, 320, 0, false, false, true));
    }
}
