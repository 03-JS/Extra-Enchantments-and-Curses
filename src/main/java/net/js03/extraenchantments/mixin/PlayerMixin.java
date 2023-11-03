package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;
import java.util.Random;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

//    @Shadow
//    public abstract PlayerAbilities getAbilities();

    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot pSlot);

    private int painCycleHits = 0;
    private Random rng = new Random();
    private static double previousMaxHealth;
    private boolean isOvershieldActive = true;
    private boolean isOvBonusActive = false;
    private int lastOvLevel;

    public PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        ItemStack itemStackFeet = this.getItemBySlot(EquipmentSlot.FEET);
        ItemStack itemStackHead = this.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack itemStackChest = this.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack itemStackLegs = this.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack itemStackMainHand = this.getItemBySlot(EquipmentSlot.MAINHAND);

        // Armor level
        int slownessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS.get(), itemStackFeet);
        int blindnessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS.get(), itemStackHead);
        int nauseaLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA.get(), itemStackHead);
        int weaknessLevelF = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackHead);
        int undeadLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD.get(), itemStackHead);
        int spectralLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SPECTRAL_VISION.get(), itemStackHead);
        int overshieldLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.OVERSHIELD.get(), itemStackChest);

        // Sword & Tools level
        int reachLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.REACH.get(), itemStackMainHand);
        int swiftnessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SWIFTNESS.get(), itemStackMainHand);
        int attritionLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_ATTRITION.get(), itemStackMainHand);

        // Armor behaviour
        if (slownessLevel > 0) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, false, false));
            this.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 3, false, false, false));
        }
        if (blindnessLevel > 0) {
            this.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false, false));
        }
        if (nauseaLevel > 0) {
            this.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 90, 0, false, false, false));
        }
        if (weaknessLevelC > 0 || weaknessLevelH > 0 || weaknessLevelL > 0 || weaknessLevelF > 0) {
            this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20, 0, false, false, false));
        }
        if (undeadLevel > 0) {
            if (this.level().canSeeSky(new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ())) && this.level().isDay()) {
                if (!this.isOnFire() && !this.level().isRaining()) {
                    this.setSecondsOnFire(7);
                }
            }
        }
        if (spectralLevel > 0) {
            this.removeEffect(MobEffects.DARKNESS);
        }
        if (overshieldLevel > 0) {
            if (!isOvershieldActive) {
                previousMaxHealth = Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).getValue();
                isOvershieldActive = true;
                Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(previousMaxHealth + overshieldLevel * 2);
                System.out.println("Previous max health (1) : " + previousMaxHealth);
            }
            isOvBonusActive = true;
            lastOvLevel = overshieldLevel;
        } else {
            if (isOvershieldActive) {
                isOvershieldActive = false;
                if (previousMaxHealth != 0 && isOvBonusActive) {
                    System.out.println("Previous max health (2) : " + previousMaxHealth);
                    System.out.println("Restore health");
                    isOvBonusActive = false;
                    Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(previousMaxHealth);
                } else {
                    if (isOvBonusActive) {
                        previousMaxHealth = Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).getValue() - (lastOvLevel * 2);
                        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(previousMaxHealth);
                        System.out.println("Previous max health (3) : " + previousMaxHealth);
                        isOvBonusActive = false;
                    }
                }
            }
        }

        // Sword & Tools behaviour
        if (reachLevel > 0) {
            Objects.requireNonNull(this.getAttribute(ForgeMod.BLOCK_REACH.get())).setBaseValue(reachLevel + ForgeMod.BLOCK_REACH.get().getDefaultValue() + 1);
            if (reachLevel <= 1) {
                Objects.requireNonNull(this.getAttribute(ForgeMod.ENTITY_REACH.get())).setBaseValue(reachLevel + ForgeMod.ENTITY_REACH.get().getDefaultValue() + 1);
            } else {
                if (reachLevel <= 3) {
                    Objects.requireNonNull(this.getAttribute(ForgeMod.ENTITY_REACH.get())).setBaseValue(reachLevel + ForgeMod.ENTITY_REACH.get().getDefaultValue());
                } else {
                    Objects.requireNonNull(this.getAttribute(ForgeMod.ENTITY_REACH.get())).setBaseValue(reachLevel + ForgeMod.ENTITY_REACH.get().getDefaultValue() - 1);
                }
            }
        } else {
            Objects.requireNonNull(this.getAttribute(ForgeMod.BLOCK_REACH.get())).setBaseValue(ForgeMod.BLOCK_REACH.get().getDefaultValue());
            Objects.requireNonNull(this.getAttribute(ForgeMod.ENTITY_REACH.get())).setBaseValue(ForgeMod.ENTITY_REACH.get().getDefaultValue());
        }
        if (swiftnessLevel > 0) {
            if (itemStackMainHand.getItem() instanceof AxeItem) {
                Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(Attributes.ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 8.4);
            } else {
                Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(Attributes.ATTACK_SPEED.getDefaultValue() + swiftnessLevel / 2.5);
            }
        } else {
            Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(Attributes.ATTACK_SPEED.getDefaultValue());
        }
        if (attritionLevel > 0) {
            if (itemStackMainHand.getItem() instanceof AxeItem) {
                Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(3.5);
            } else {
                Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(3.1);
            }
        } else {
            if (swiftnessLevel <= 0) {
                Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_SPEED)).setBaseValue(Attributes.ATTACK_SPEED.getDefaultValue());
            }
        }
    }

    @Inject(method = "attack", at = @At("TAIL"))
    private void attack(Entity target, CallbackInfo ci) {
        ItemStack itemStackMainHand = this.getItemBySlot(EquipmentSlot.MAINHAND);

        int freezingAspectLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.FREEZING_ASPECT.get(), itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (freezingAspectLevel > 0 && !target.isFullyFrozen() && !target.isInLava() && !target.level().dimensionType().ultraWarm()) {
                target.setTicksFrozen(freezingAspectLevel * 360);
            }
        }

        int enigmaResonatorLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.ENIGMA_RESONATOR.get(), itemStackMainHand);
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

        int painCycleLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.PAIN_CYCLE.get(), itemStackMainHand);
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

        int soulReaperLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SOUL_REAPER.get(), itemStackMainHand);
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

        int frenzyLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.FRENZY.get(), itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (frenzyLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDeadOrDying()) {
                    int rng = (int) (Math.random() * 3);
                    if (rng == 0) {
                        this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120, frenzyLevel - 1, false, false, true));
                        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, frenzyLevel - 1, false, false, true));
                    }
                }
            }
        }

        int guardingStrikeLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.GUARDING_STRIKE.get(), itemStackMainHand);
        if (target instanceof LivingEntity) {
            if (guardingStrikeLevel > 0) {
                if (isEntityHostileOrNeutral && ((LivingEntity) target).isDeadOrDying()) {
                    this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, guardingStrikeLevel - 1, false, false, true));
                }
            }
        }

        int lifestealLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.LIFESTEAL.get(), itemStackMainHand);
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

    @ModifyVariable(method = "giveExperiencePoints(I)V", at = @At("HEAD"), argsOnly = true)
    private int addExperienceIncrease(int experience) {
        return EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.EXPERIENCE_CATALYST.get(), this.getItemBySlot(EquipmentSlot.MAINHAND)) > 0
                ?
                experience * EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.EXPERIENCE_CATALYST.get(), this.getItemBySlot(EquipmentSlot.MAINHAND))
                : experience;
    }
}
