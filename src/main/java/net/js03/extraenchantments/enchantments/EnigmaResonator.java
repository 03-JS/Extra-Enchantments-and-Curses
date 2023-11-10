package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;

public class EnigmaResonator extends Enchantment {
    public EnigmaResonator(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.enigmaResonator.target(), slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.enigmaResonator.maxLevel();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof PainCycle) && !(other instanceof HealthForBlood) && !(other instanceof Frenzy) && !(other instanceof GuardingStrike) && !(other instanceof SoulReaper);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Enigma Resonator", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.enigmaResonator.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.enigmaResonator.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.enigmaResonator.isAvailableForRandomSelection();
    }

    //    @Override
//    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
//        if (target instanceof LivingEntity) {
//            if (!((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
//                int rng = (int) (Math.random() * 35);
//                if (rng <= level) {
//                    if (((LivingEntity) target).getRecentDamageSource() != null) {
//                        target.damage(target.getDamageSources().generic(), (float) (user.getHealth() * 0.75));
//                    }
//                }
//            }
//        }
//    }
}
