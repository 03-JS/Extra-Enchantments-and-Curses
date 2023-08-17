package net.js03.extraenchantments.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

//    @Shadow
//    public abstract PlayerAbilities getAbilities();

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
        int slownessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackFeet);
        int blindnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackHead);
        int nauseaLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackHead);
        int weaknessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackHead);
        int undeadLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD, itemStackHead);
        int spectralLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SPECTRAL_VISION, itemStackHead);
        int reachLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.REACH, itemStackMainHand);
        int swiftnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.SWIFTNESS, itemStackMainHand);
        int attritionLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_ATTRITION, itemStackMainHand);
        int overshieldLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackChest);
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
        if (overshieldLevel > 0) {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue() + overshieldLevel * 2);
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue());
        }
    }
}
