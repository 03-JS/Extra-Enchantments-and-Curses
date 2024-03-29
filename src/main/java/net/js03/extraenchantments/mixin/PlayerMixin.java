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
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow
    public abstract HungerManager getHungerManager();

    @Shadow
    public abstract PlayerAbilities getAbilities();

    private int painCycleHits = 0;
    private Random rng = new Random();

    private static double previousMaxHealth;
    private boolean isOvershieldActive = true;
    private boolean isOvBonusActive = false;
    private int lastOvLevel;

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
        int slownessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackHead);
        int slownessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackChest);
        int slownessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackLegs);
        int slownessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackFeet);
        int blindnessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackHead);
        int blindnessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackChest);
        int blindnessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackLegs);
        int blindnessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackFeet);
        int nauseaLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackHead);
        int nauseaLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackChest);
        int nauseaLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackLegs);
        int nauseaLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackFeet);
        int weaknessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackHead);
        int undeadLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD, itemStackHead);
        int spectralLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SPECTRAL_VISION, itemStackHead);
        int overshieldLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackHead);
        int overshieldLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackChest);
        int overshieldLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackLegs);
        int overshieldLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackFeet);

        // Sword & Tools level
        int reachLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.REACH, itemStackMainHand);
        int swiftnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SWIFTNESS, itemStackMainHand);
        int attritionLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_ATTRITION, itemStackMainHand);

        // Armor behaviour
        if (slownessLevelH > 0 || slownessLevelC > 0 || slownessLevelL > 0 || slownessLevelF > 0 && !ExtraEnchantsMain.CONFIG.curseOfSlowness.effectsDisabled()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 3, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 20, 3, false, false, false));
        }
        if (blindnessLevelH > 0 || blindnessLevelC > 0 || blindnessLevelL > 0 || blindnessLevelF > 0 && !ExtraEnchantsMain.CONFIG.curseOfBlindness.effectsDisabled()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 40, 0, false, false, false));
        }
        if (nauseaLevelH > 0 || nauseaLevelC > 0 || nauseaLevelL > 0 || nauseaLevelF > 0 && !ExtraEnchantsMain.CONFIG.curseOfNausea.effectsDisabled()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 90, 0, false, false, false));
        }
        if (weaknessLevelC > 0 || weaknessLevelH > 0 || weaknessLevelL > 0 || weaknessLevelF > 0 && !ExtraEnchantsMain.CONFIG.curseOfWeakness.effectsDisabled()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20, 0, false, false, false));
        }
        if (undeadLevel > 0 && !ExtraEnchantsMain.CONFIG.curseOfUndead.effectsDisabled()) {
            if (this.getWorld().isSkyVisible(this.getBlockPos()) && this.getWorld().isDay()) {
                if (!this.isOnFire() && !this.getWorld().isRaining()) {
                    this.setOnFireFor(7);
                }
            }
        }
        if (spectralLevel > 0 && !ExtraEnchantsMain.CONFIG.spectralVision.effectsDisabled()) {
            this.removeStatusEffect(StatusEffects.DARKNESS);
        }
        if (!ExtraEnchantsMain.CONFIG.overshield.effectsDisabled()) {
            if (overshieldLevelH > 0 || overshieldLevelC > 0 || overshieldLevelL > 0 || overshieldLevelF > 0) {
                if (!isOvershieldActive) {
                    previousMaxHealth = Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).getValue();
                    isOvershieldActive = true;
                    if (overshieldLevelH > 0) {
                        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth + overshieldLevelH * 2);
                    }
                    if (overshieldLevelC > 0) {
                        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth + overshieldLevelC * 2);
                    }
                    if (overshieldLevelL > 0) {
                        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth + overshieldLevelL * 2);
                    }
                    if (overshieldLevelF > 0) {
                        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth + overshieldLevelF * 2);
                    }
                    System.out.println("Previous max health (1) : " + previousMaxHealth);
                }
                isOvBonusActive = true;
                if (overshieldLevelH > 0) {
                    lastOvLevel = overshieldLevelH;
                } else if (overshieldLevelC > 0) {
                    lastOvLevel = overshieldLevelC;
                } else if (overshieldLevelL > 0) {
                    lastOvLevel = overshieldLevelL;
                } else if (overshieldLevelF > 0) {
                    lastOvLevel = overshieldLevelF;
                }
            } else {
                if (isOvershieldActive) {
                    isOvershieldActive = false;
                    if (previousMaxHealth != 0 && isOvBonusActive) {
                        System.out.println("Previous max health (2) : " + previousMaxHealth);
                        System.out.println("Restore health");
                        isOvBonusActive = false;
                        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth);
                    } else {
                        if (isOvBonusActive) {
                            previousMaxHealth = Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).getValue() - (lastOvLevel * 2);
                            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth);
                            System.out.println("Previous max health (3) : " + previousMaxHealth);
                            isOvBonusActive = false;
                        }
                    }
                }
            }
        } else {
            isOvershieldActive = false;
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(previousMaxHealth);
        }

        // Sword & Tools behaviour
        if (reachLevel > 0 && !ExtraEnchantsMain.CONFIG.reach.effectsDisabled()) {
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
        if (swiftnessLevel > 0 && !ExtraEnchantsMain.CONFIG.swiftness.effectsDisabled()) {
            if (itemStackMainHand.getItem() instanceof AxeItem) {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 8.4);
            } else {
                Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 2.5);
            }
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED)).setBaseValue(EntityAttributes.GENERIC_ATTACK_SPEED.getDefaultValue());
        }
        if (attritionLevel > 0 && !ExtraEnchantsMain.CONFIG.curseOfAttrition.effectsDisabled()) {
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
        boolean isEntityHostileOrNeutral = target instanceof HostileEntity || target instanceof PlayerEntity || target instanceof HoglinEntity || target instanceof BeeEntity
                || target instanceof DolphinEntity || target instanceof GoatEntity || target instanceof GolemEntity || target instanceof LlamaEntity
                || target instanceof TraderLlamaEntity || target instanceof PandaEntity || target instanceof PolarBearEntity || target instanceof WolfEntity
                || target instanceof PufferfishEntity || target instanceof SlimeEntity || target instanceof MagmaCubeEntity || target instanceof PhantomEntity
                || target instanceof EnderDragonEntity;

        if (!ExtraEnchantsMain.CONFIG.freezingAspect.effectsDisabled()) {
            int freezingAspectLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.FREEZING_ASPECT, this);
            if (target instanceof LivingEntity) {
                if (freezingAspectLevel > 0 && !target.isFrozen() && !target.isInLava() && !target.getWorld().getDimension().ultrawarm()) {
                    target.setFrozenTicks(freezingAspectLevel * 360);
                }
            }
        }

        if (!ExtraEnchantsMain.CONFIG.enigmaResonator.effectsDisabled()) {
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
        }

        if (!ExtraEnchantsMain.CONFIG.painCycle.effectsDisabled()) {
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
        }

        if (!ExtraEnchantsMain.CONFIG.soulReaper.effectsDisabled()) {
            int soulReaperLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.SOUL_REAPER, this);
            if (target instanceof LivingEntity) {
                if (soulReaperLevel > 0) {
                    if (isEntityHostileOrNeutral) {
                        int healingAmount = rng.nextInt(1, 5);
                        int healingChance = rng.nextInt(6);
                        if (healingChance <= 1) {
                            this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.PARTICLE_SOUL_ESCAPE, SoundCategory.MASTER, 3f, 1f);
                            this.heal(healingAmount);
                        }
                    }
                }
            }
        }

        if (!ExtraEnchantsMain.CONFIG.frenzy.effectsDisabled()) {
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
        }

        if (!ExtraEnchantsMain.CONFIG.guardingStrike.effectsDisabled()) {
            int guardingStrikeLevel = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.GUARDING_STRIKE, this);
            if (target instanceof LivingEntity) {
                if (guardingStrikeLevel > 0) {
                    if (isEntityHostileOrNeutral && ((LivingEntity) target).isDead()) {
                        this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 120, guardingStrikeLevel - 1, false, true, true));
                    }
                }
            }
        }

        if (!ExtraEnchantsMain.CONFIG.lifesteal.effectsDisabled()) {
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

    @ModifyVariable(method = "addExperience(I)V", at = @At("HEAD"), argsOnly = true)
    private int addExperienceIncrease(int experience) {
        if (ExtraEnchantsMain.CONFIG.xpCatalyst.effectsDisabled()) {
            return experience;
        }
        return EnchantmentHelper.getLevel(ExtraEnchantsMain.EXPERIENCE_CATALYST, this.getEquippedStack(EquipmentSlot.MAINHAND)) > 0
                ?
                experience * EnchantmentHelper.getLevel(ExtraEnchantsMain.EXPERIENCE_CATALYST, this.getEquippedStack(EquipmentSlot.MAINHAND))
                : experience;
    }


    /**
     * @author JS03
     * @reason To easily modify the amount of exhaustion the player receives
     */
    @Overwrite
    public void addExhaustion(float exhaustion) {
        if (this.getAbilities().invulnerable) {
            return;
        }
        if (!this.getWorld().isClient) {
            if (EnchantmentHelper.getLevel(ExtraEnchantsMain.ENERGIZED, this.getEquippedStack(EquipmentSlot.LEGS)) > 0) {
                if (!ExtraEnchantsMain.CONFIG.energized.effectsDisabled()) {
                    this.getHungerManager().addExhaustion(exhaustion / 2);
                }
            } else {
                this.getHungerManager().addExhaustion(exhaustion);
            }
        }
    }
}
