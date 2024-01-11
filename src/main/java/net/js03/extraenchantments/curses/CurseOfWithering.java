package net.js03.extraenchantments.curses;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class CurseOfWithering extends Enchantment {
    public CurseOfWithering(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.curseOfWithering.target(), slotTypes);
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
        return ExtraEnchantsMain.CONFIG.curseOfWithering.maxLevel();
    }

    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.curseOfWithering.isTreasure();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Withering Curse", stack, target);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.curseOfWithering.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.curseOfWithering.isAvailableForRandomSelection();
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (!ExtraEnchantsMain.CONFIG.curseOfWithering.effectsDisabled()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 320, 0, false, false, true));
        }
    }
}
