package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.js03.extraenchantments.curses.CurseOfZeus;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;


public class Electrified extends Enchantment {

    private int hitsTarget;
    private int hitsAttacker;
    private int rng;

    public Electrified(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.electrified.target(), slotTypes);
        hitsTarget = 0;
        hitsAttacker = 0;
        rng = 0;
    }

    @Override
    public int getProtectionAmount(int level, DamageSource source) {
        return source.isIn(DamageTypeTags.IS_LIGHTNING) ? 4 : 0;
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.electrified.isTreasure();
    }

    @Override
    public int getMinPower(int level) {
        return 40;
    }

    @Override
    public int getMaxPower(int level) {
        return 70;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.electrified.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Electrified", stack, target);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.electrified.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.electrified.isAvailableForRandomSelection();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof CurseOfZeus);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!ExtraEnchantsMain.CONFIG.electrified.effectsDisabled()) {
            rng = (int) (Math.random() * 11);
            if (user.getWorld().isThundering()) {
                hitsTarget++;
                if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
                    if (target instanceof PlayerEntity) {
                        summonLightning(target, hitsTarget);
                    } else {
                        if (((LivingEntity) target).getHealth() > 5) {
                            summonLightning(target, hitsTarget);
                        }
                    }
                }
                if (hitsTarget == 4) {
                    hitsTarget = 0;
                }
            }
        }
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (!ExtraEnchantsMain.CONFIG.electrified.effectsDisabled()) {
            rng = (int) (Math.random() * 11);
            if (user.getWorld().isThundering()) {
                hitsAttacker++;
                if (attacker instanceof LivingEntity) {
                    if (attacker instanceof PlayerEntity) {
                        summonLightning(attacker, hitsAttacker);
                    } else {
                        if (((LivingEntity) attacker).getHealth() > 5) {
                            summonLightning(attacker, hitsAttacker);
                        }
                    }
                }
                if (hitsAttacker == 4) {
                    hitsAttacker = 0;
                }
            }
        }
    }

    private void summonLightning(Entity entity, int hits) {
        if (rng <= 2 && hits == 1) {
            System.out.println("RNG: " + rng + "\nAttacker Hits: " + hitsAttacker + "\nTarget Hits: " + hitsTarget);
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entity.getWorld());
            assert lightningEntity != null;
            lightningEntity.refreshPositionAfterTeleport(entity.getX(), entity.getY(), entity.getZ());
            entity.getWorld().spawnEntity(lightningEntity);
        }
    }
}
