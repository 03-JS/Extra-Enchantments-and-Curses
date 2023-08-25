package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {

    private int painCycleHits = 0;
    private Random rng = new Random();

    public MobMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "doHurtTarget", at = @At("TAIL"))
    private void attack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        int freezingAspectLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.FREEZING_ASPECT.get(), this);
        if (target instanceof LivingEntity) {
            if (freezingAspectLevel > 0 && !target.isFullyFrozen() && !target.isInLava() && !target.level().dimensionType().ultraWarm()) {
                target.setTicksFrozen(freezingAspectLevel * 360);
            }
        }

        int enigmaResonatorLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.ENIGMA_RESONATOR.get(), this);
        if (target instanceof LivingEntity) {
            if (enigmaResonatorLevel > 0) {
                int rng = (int) (Math.random() * 35);
                if (rng <= enigmaResonatorLevel) {
                    if (((LivingEntity) target).getLastDamageSource() != null) {
                        this.level().playSound(null, target.blockPosition(), SoundEvents.ARROW_HIT_PLAYER, SoundSource.MASTER, 1f, 1f);
                        target.hurt(target.damageSources().generic(), (float) (this.getHealth() * 0.75));
                    }
                }
            }
        }

        boolean isEntityHostileOrNeutral = target instanceof Monster || target instanceof Player || target instanceof Hoglin || target instanceof Bee
                || target instanceof Dolphin || target instanceof Goat || target instanceof IronGolem || target instanceof SnowGolem || target instanceof Llama
                || target instanceof TraderLlama || target instanceof Panda || target instanceof PolarBear || target instanceof Wolf
                || target instanceof Pufferfish || target instanceof Slime || target instanceof MagmaCube || target instanceof Phantom
                || target instanceof EnderDragon;

        int painCycleLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.PAIN_CYCLE.get(), this);
        if (target instanceof LivingEntity) {
            if (painCycleLevel > 0) {
                if (isEntityHostileOrNeutral) {
                    if (painCycleHits >= 3) {
                        if (((LivingEntity) target).getLastDamageSource() != null) {
                            target.hurt(this.damageSources().magic(), 20);
                            this.level().playSound(null, target.blockPosition(), SoundEvents.ARROW_HIT_PLAYER, SoundSource.MASTER, 1f, 1f);
                            painCycleHits = 0;
                        }
                    } else {
                        painCycleHits++;
                        if (this.getHealth() <= 1) {
                            this.hurt(this.damageSources().magic(), 100);
                        } else {
                            this.setHealth(this.getHealth() - 1f);
                        }
                        this.level().playSound(null, this.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.MASTER, 3f, 1f);
                    }
                }
            }
        }

        int soulReaperLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.SOUL_REAPER.get(), this);
        if (target instanceof LivingEntity) {
            if (soulReaperLevel > 0) {
                if (isEntityHostileOrNeutral) {
                    int healingAmount = rng.nextInt(1,5);
                    int healingChance = rng.nextInt(6);
                    if (healingChance <= 1) {
                        this.level().playSound(null, this.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.MASTER, 3f, 1f);
                        this.heal(healingAmount);
                    }
                }
            }
        }

        int frenzyLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.FRENZY.get(), this);
        if (target instanceof LivingEntity) {
            if (frenzyLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDeadOrDying()) {
                    int rng = (int) (Math.random() * 3);
                    if (rng == 0) {
                        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, frenzyLevel - 1, false, true, true));
                        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, frenzyLevel - 1, false, true, true));
                    }
                }
            }
        }

        int guardingStrikeLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.GUARDING_STRIKE.get(), this);
        if (target instanceof LivingEntity) {
            if (guardingStrikeLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDeadOrDying()) {
                    this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, guardingStrikeLevel - 1, false, true, true));
                }
            }
        }

        int lifestealLevel = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.LIFESTEAL.get(), this);
        if (target instanceof LivingEntity) {
            if (lifestealLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDeadOrDying()) {
                    float percentage = 0.001f;
                    percentage *= lifestealLevel;
                    this.level().playSound(null, this.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.MASTER, 3f, 1f);
                    this.heal((((LivingEntity) target).getMaxHealth() * percentage));
                }
            }
        }
    }
}
