package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

//    @Shadow
//    public abstract PlayerAbilities getAbilities();

    @Shadow public abstract ItemStack getItemBySlot(EquipmentSlot pSlot);

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
        int slownessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS.get(), itemStackFeet);
        int blindnessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS.get(), itemStackHead);
        int nauseaLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA.get(), itemStackHead);
        int weaknessLevelF = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS.get(), itemStackHead);
        int undeadLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD.get(), itemStackHead);
        int spectralLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SPECTRAL_VISION.get(), itemStackHead);
        int reachLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.REACH.get(), itemStackMainHand);
        int swiftnessLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SWIFTNESS.get(), itemStackMainHand);
        int attritionLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.CURSE_OF_ATTRITION.get(), itemStackMainHand);
        int overshieldLevel = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.OVERSHIELD.get(), itemStackChest);
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
        if (overshieldLevel > 0) {
            Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(Attributes.MAX_HEALTH.getDefaultValue() + overshieldLevel * 2);
        } else {
            Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(Attributes.MAX_HEALTH.getDefaultValue());
        }
    }
}
