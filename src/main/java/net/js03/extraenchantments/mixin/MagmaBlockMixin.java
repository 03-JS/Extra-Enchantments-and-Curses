package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MagmaBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MagmaBlock.class)
public class MagmaBlockMixin extends Block {
    public MagmaBlockMixin(Properties pProperties) {
        super(pProperties);
    }

    @Overwrite
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if (!pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)pEntity) && EnchantmentHelper.getEnchantmentLevel(ExtraEnchantsMain.HELLWALKER.get(), (LivingEntity) pEntity) < 0) {
            pEntity.hurt(pLevel.damageSources().hotFloor(), 1.0F);
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
