package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;

public class LevitationalShot extends Enchantment {

    public LevitationalShot(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
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
        return ExtraEnchantsMain.CONFIG.levitationalShot.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Levitational Shot", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.levitationalShot.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.levitationalShot.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.levitationalShot.isAvailableForRandomSelection();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.QUICK_CHARGE && other != Enchantments.POWER && other != Enchantments.PUNCH && other != Enchantments.FLAME && other != Enchantments.INFINITY && !(other instanceof ResonatingShot) && !(other instanceof ElectrifyingShot) && !(other instanceof ShadowShot);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!ExtraEnchantsMain.CONFIG.levitationalShot.effectsDisabled()) {
            if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
                if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
                    ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2, 99, false, false, false));
                }
            }
        }
    }
}
