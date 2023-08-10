package net.fabricmc.extraenchantments.mixin;

import net.fabricmc.extraenchantments.ExtraEnchantsMain;
import net.fabricmc.extraenchantments.enchantments.HellWalker;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Shadow @Nullable public abstract EntityAttributeInstance getAttributeInstance(EntityAttribute attribute);

    @Shadow public abstract void setHealth(float health);

    @Inject(method = "applyMovementEffects", at = @At("HEAD"))
    private void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        LivingEntity casted = (LivingEntity) (Object) this;
        int i = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HELLWALKER, casted);
        if (i > 0) {
            HellWalker.freezeLava(casted, this.getWorld(), pos);
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick (CallbackInfo ci) {
        ItemStack itemStackChest = this.getEquippedStack(EquipmentSlot.CHEST);
        int overshieldLevel = EnchantmentHelper.getLevel(ExtraEnchantsMain.OVERSHIELD, itemStackChest);
        if (overshieldLevel > 0) {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue() + overshieldLevel * 2);
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue());
            // this.setHealth((float) EntityAttributes.GENERIC_MAX_HEALTH.getDefaultValue());
        }
    }
}
