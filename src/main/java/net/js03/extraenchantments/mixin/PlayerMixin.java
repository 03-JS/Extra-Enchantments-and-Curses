package net.js03.extraenchantments.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stat;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    private int painCycleHits = 0;
    private Random rng = new Random();

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        ItemStack itemStackFeet = this.getEquippedStack(EquipmentSlot.FEET);
        ItemStack itemStackHead = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack itemStackChest = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackLegs = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack itemStackMainHand = this.getEquippedStack(EquipmentSlot.MAINHAND);

        // Armor level
        int slownessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackFeet);
        int blindnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackHead);
        int nauseaLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackHead);
        int weaknessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackHead);
        int undeadLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD, itemStackHead);
        int spectralLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SPECTRAL_VISION, itemStackHead);
        int overshieldLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackChest);

        // Sword & Tools level
        int reachLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.REACH, itemStackMainHand);
        int swiftnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SWIFTNESS, itemStackMainHand);
        int attritionLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_ATTRITION, itemStackMainHand);

        // Armor behaviour
        if (slownessLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 3, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20, 3, false, false, false));
        }
        if (blindnessLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 40, 0, false, false, false));
        }
        if (nauseaLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 90, 0, false, false, false));
        }
        if (weaknessLevelC > 0 || weaknessLevelH > 0 || weaknessLevelL > 0 || weaknessLevelF > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 0, false, false, false));
        }
        if (undeadLevel > 0) {
            if (this.getWorld().isSkyVisible(this.getBlockPos()) && this.getWorld().isDay()) {
                if (!this.isOnFire() && !this.getWorld().isRaining()) {
                    this.setOnFireFor(7);
                }
            }
        }
        if (spectralLevel > 0) {
            this.removeStatusEffect(StatusEffects.DARKNESS);
        }
        if (overshieldLevel > 0) {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue() + overshieldLevel * 2);
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue());
        }

        // Sword & Tools behaviour
        if (reachLevel > 0) {
            Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.REACH)).setBaseValue(reachLevel + 1);
            if (reachLevel <= 1) {
                Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE)).setBaseValue(reachLevel + 1);
            } else {
                if (reachLevel <= 3) {
                    Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE)).setBaseValue(reachLevel);
                } else {
                    Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE)).setBaseValue(reachLevel - 1);
                }
            }
        } else {
            Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.REACH)).setBaseValue(0.0);
            Objects.requireNonNull(this.getAttributeInstance(ReachEntityAttributes.ATTACK_RANGE)).setBaseValue(0.0);
        }

        if (swiftnessLevel > 0) {
            if (itemStackMainHand.getItem() instanceof AxeItem) {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 8.4);
            } else {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 2.5);
            }
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue());
        }
        if (attritionLevel > 0) {
            if (itemStackMainHand.getItem() instanceof AxeItem) {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(3.5);
            } else {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(3.1);
            }
        } else {
            if (swiftnessLevel <= 0) {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue());
            }
        }
    }

    @Inject(method = "attack", at = @At("TAIL"))
    private void attack(Entity target, CallbackInfo ci) {
        ItemStack itemStackMainHand = this.getEquippedStack(EquipmentSlot.MAINHAND);

        int freezingAspectLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.FREEZING_ASPECT, itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (freezingAspectLevel > 0 && !target.isFrozen()) {
                target.setFrozenTicks(freezingAspectLevel * 360);
            }
        }

        int enigmaResonatorLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.ENIGMA_RESONATOR, itemStackMainHand);
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

        int painCycleLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.PAIN_CYCLE, itemStackMainHand);
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

        int soulReaperLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SOUL_REAPER, itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (soulReaperLevel > 0) {
                if (isEntityHostileOrNeutral) {
                    int healingAmount = rng.nextInt(4);
                    int healingChance = rng.nextInt(6);
                    if (healingChance <= 1) {
                        this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.MASTER, 3f, 1f);
                        this.heal(healingAmount);
                    }
                }
            }
        }

        int frenzyLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.FRENZY, itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (frenzyLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                    int rng = (int) (Math.random() * 3);
                    if (rng == 0) {
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 120, frenzyLevel - 1, false, false, true));
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, frenzyLevel - 1, false, false, true));
                    }
                }
            }
        }

        int guardingStrikeLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.GUARDING_STRIKE, itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (guardingStrikeLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                    this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 120, guardingStrikeLevel - 1, false, false, true));
                }
            }
        }

        int lifestealLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.HEALTH_FOR_BLOOD, itemStackMainHand);
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
