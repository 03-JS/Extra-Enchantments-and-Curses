package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class CurseOfNausea extends Enchantment {
    public CurseOfNausea(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfNausea.target(), slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.curseOfNausea.maxLevel();
    }

    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.curseOfNausea.isTreasure();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Nausea Curse", stack, target);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.curseOfNausea.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.curseOfNausea.isAvailableForRandomSelection();
    }

    //    @Override
//    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
//        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 320, 0, false, false, true));
//    }
}
