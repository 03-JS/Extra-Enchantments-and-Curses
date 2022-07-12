package net.fabricmc.extraenchantments.mixin;

import net.fabricmc.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin extends LivingEntity {
    @Shadow
    public abstract void addExperienceLevels(int levels);

    @Shadow
    public int experienceLevel;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        ItemStack itemStackFeet = this.getEquippedStack(EquipmentSlot.FEET);
        ItemStack itemStackHead = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack itemStackChest = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackLegs = this.getEquippedStack(EquipmentSlot.LEGS);
        int slownessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_SLOWNESS, itemStackFeet);
        int blindnessLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_BLINDNESS, itemStackHead);
        int nauseaLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_NAUSEA, itemStackHead);
        int weaknessLevelF = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackFeet);
        int weaknessLevelL = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackLegs);
        int weaknessLevelC = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackChest);
        int weaknessLevelH = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_WEAKNESS, itemStackHead);
        int undeadLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_UNDEAD, itemStackHead);
        if (slownessLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 999999, 3, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 999999, 3, false, false, false));
        } else {
            this.removeStatusEffect(StatusEffects.SLOWNESS);
            this.removeStatusEffect(StatusEffects.MINING_FATIGUE);
        }
        if (blindnessLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 999999, 0, false, false, false));
        } else {
            this.removeStatusEffect(StatusEffects.BLINDNESS);
        }
        if (nauseaLevel > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 90, 0, false, false, false));
        }
        if (weaknessLevelC > 0 || weaknessLevelH > 0 || weaknessLevelL > 0 || weaknessLevelF > 0) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 999999, 0, false, false, false));
        } else {
            this.removeStatusEffect(StatusEffects.WEAKNESS);
        }
        if (undeadLevel > 0) {
            if (this.world.isSkyVisible(this.getBlockPos()) && this.world.isDay()) {
                if (!this.isOnFire() && !this.world.isRaining()) {
                    this.setOnFireFor(7);
                }
            }
        }
    }
}
