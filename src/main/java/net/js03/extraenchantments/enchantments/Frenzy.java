package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;

public class Frenzy extends Enchantment {
    public Frenzy(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 9;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.frenzy.maxLevel();
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof HealthForBlood);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Frenzy", stack, target);
    }

    @Override
    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.frenzy.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.frenzy.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.frenzy.isAvailableForRandomSelection();
    }

    //    @Override
//    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
//        int rng = (int) (Math.random() * 3);
//        if (target instanceof HostileEntity || target instanceof PlayerEntity || target instanceof HoglinEntity || target instanceof BeeEntity
//                || target instanceof DolphinEntity || target instanceof GoatEntity || target instanceof GolemEntity || target instanceof LlamaEntity
//                || target instanceof TraderLlamaEntity || target instanceof PandaEntity || target instanceof PolarBearEntity || target instanceof WolfEntity
//                || target instanceof PufferfishEntity || target instanceof SlimeEntity || target instanceof MagmaCubeEntity || target instanceof PhantomEntity
//                || target instanceof EnderDragonEntity) {
//            if (((LivingEntity) target).isDead() && !((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE)) {
//                if (rng == 0) {
//                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120, level - 1, false, false, true));
//                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, level - 1, false, false, true));
//                }
//            }
//        }
//    }
}
