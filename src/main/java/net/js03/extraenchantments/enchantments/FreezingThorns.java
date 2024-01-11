package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class FreezingThorns extends Enchantment {
    public FreezingThorns(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.freezingThorns.target(), slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 11 + 21 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 51;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.freezingThorns.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Freezing Thorns", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.freezingThorns.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.freezingThorns.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.freezingThorns.isAvailableForRandomSelection();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.THORNS && !(other instanceof BurningThorns);
    }

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (!ExtraEnchantsMain.CONFIG.freezingThorns.effectsDisabled()) {
            int rng = (int) (1 + Math.random() * 4);
            if (attacker instanceof LivingEntity && rng <= level && !(attacker instanceof BlazeEntity) && !(attacker instanceof MagmaCubeEntity)) {
                if (!user.getWorld().getDimension().ultrawarm() && !attacker.isFrozen() && !attacker.isInLava()) {
                    attacker.setFrozenTicks(400);
                }
            }
        }
    }

}
