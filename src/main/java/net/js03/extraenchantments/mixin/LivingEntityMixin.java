package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.enchantments.HellWalker;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "applyMovementEffects", at = @At("HEAD"))
    private void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        LivingEntity casted = (LivingEntity) (Object) this;
        int i = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HELLWALKER, casted);
        if (i > 0) {
            HellWalker.freezeLava(casted, this.getWorld(), pos);
        }
    }
}
