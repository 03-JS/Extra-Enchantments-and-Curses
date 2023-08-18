package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.enchantments.HellWalker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(method = "onChangedBlock", at = @At("HEAD"))
    private void onChangedBlock(BlockPos pos, CallbackInfo ci) {
        LivingEntity casted = (LivingEntity) (Object) this;
        int i = EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.HELLWALKER.get(), casted);
        if (i > 0) {
            HellWalker.freezeLava(casted, this.level(), pos);
        }
    }
}
