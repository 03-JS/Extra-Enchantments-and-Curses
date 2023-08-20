package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(MobEntity.class)
public abstract class MobMixin extends LivingEntity {

    private int painCycleHits = 0;
    private Random rng = new Random();

    public MobMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tryAttack", at = @At("TAIL"))
    private void attack(Entity target, CallbackInfoReturnable<Boolean> cir) {
        int freezingAspectLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.FREEZING_ASPECT, this);
        if (target instanceof LivingEntity) {
            if (freezingAspectLevel > 0 && !target.isFrozen()) {
                target.setFrozenTicks(freezingAspectLevel * 360);
            }
        }

        int enigmaResonatorLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.ENIGMA_RESONATOR, this);
        if (target instanceof LivingEntity) {
            if (enigmaResonatorLevel > 0) {
                int rng = (int) (Math.random() * 35);
                if (rng <= enigmaResonatorLevel) {
                    if (((LivingEntity) target).getRecentDamageSource() != null) {
                        this.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f);
                        target.damage(target.getDamageSources().generic(), (float) (this.getHealth() * 0.75));
                    }
                }
            }
        }

        boolean isEntityHostileOrNeutral = target instanceof HostileEntity || target instanceof PlayerEntity || target instanceof HoglinEntity || target instanceof BeeEntity
                || target instanceof DolphinEntity || target instanceof GoatEntity || target instanceof GolemEntity || target instanceof LlamaEntity
                || target instanceof TraderLlamaEntity || target instanceof PandaEntity || target instanceof PolarBearEntity || target instanceof WolfEntity
                || target instanceof PufferfishEntity || target instanceof SlimeEntity || target instanceof MagmaCubeEntity || target instanceof PhantomEntity
                || target instanceof EnderDragonEntity;

        int painCycleLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.PAIN_CYCLE, this);
        if (target instanceof LivingEntity) {
            if (painCycleLevel > 0) {
                if (isEntityHostileOrNeutral) {
                    if (painCycleHits >= 3) {
                        if (((LivingEntity) target).getRecentDamageSource() != null) {
                            target.damage(this.getDamageSources().magic(), 20);
                            this.getWorld().playSound(null, target.getBlockPos(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f);
                            painCycleHits = 0;
                        }
                    } else {
                        painCycleHits++;
                        if (this.getHealth() <= 1) {
                            this.damage(this.getDamageSources().magic(), 100);
                        } else {
                            this.setHealth(this.getHealth() - 1f);
                        }
                        this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.MASTER, 3f, 1f);
                    }
                }
            }
        }

        int soulReaperLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.SOUL_REAPER, this);
        if (target instanceof LivingEntity) {
            if (soulReaperLevel > 0) {
                if (isEntityHostileOrNeutral) {
                    int healingAmount = rng.nextInt(1,5);
                    int healingChance = rng.nextInt(6);
                    if (healingChance <= 1) {
                        this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.MASTER, 3f, 1f);
                        this.heal(healingAmount);
                    }
                }
            }
        }

        int frenzyLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.FRENZY, this);
        if (target instanceof LivingEntity) {
            if (frenzyLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                    int rng = (int) (Math.random() * 3);
                    if (rng == 0) {
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120, frenzyLevel - 1, false, true, true));
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, frenzyLevel - 1, false, true, true));
                    }
                }
            }
        }

        int guardingStrikeLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.GUARDING_STRIKE, this);
        if (target instanceof LivingEntity) {
            if (guardingStrikeLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 120, guardingStrikeLevel - 1, false, true, true));
                }
            }
        }

        int lifestealLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HEALTH_FOR_BLOOD, this);
        if (target instanceof LivingEntity) {
            if (lifestealLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                    float percentage = 0.001f;
                    percentage *= lifestealLevel;
                    this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.MASTER, 3f, 1f);
                    this.heal((((LivingEntity) target).getMaxHealth() * percentage));
                }
            }
        }
    }
}
