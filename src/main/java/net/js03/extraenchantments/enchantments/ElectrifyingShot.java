package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;

public class ElectrifyingShot extends Enchantment {
    public ElectrifyingShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.electrifyingShot.target(), slotTypes);
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
        return ExtraEnchantsMain.CONFIG.electrifyingShot.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Electrifying Shot", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.electrifyingShot.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.electrifyingShot.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.electrifyingShot.isAvailableForRandomSelection();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.QUICK_CHARGE && other != Enchantments.PIERCING && other != Enchantments.MULTISHOT && !(other instanceof HotShot) && !(other instanceof LevitationalShot) && !(other instanceof Supercharge);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!ExtraEnchantsMain.CONFIG.electrifyingShot.effectsDisabled()) {
            int rng = (int) (Math.random() * 11);
            if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
                if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE) && user.getWorld().isThundering()) {
                    if (rng <= 2) {
                        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.getWorld());
                        assert lightningEntity != null;
                        lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                        target.getWorld().spawnEntity(lightningEntity);
                    }
                }
            }
        }
    }

}
