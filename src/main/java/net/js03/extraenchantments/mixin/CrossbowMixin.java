package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public abstract class CrossbowMixin extends RangedWeaponItem implements Vanishable {

    public CrossbowMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "createArrow", at = @At("TAIL"))
    private static void createArrow(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow, CallbackInfoReturnable<PersistentProjectileEntity> cir) {
        // Incandescent
        int i = EnchantmentHelper.getLevel(ExtraEnchantsMain.HOT_SHOT, crossbow);
        if (i > 0 && !ExtraEnchantsMain.CONFIG.incandescent.effectsDisabled()) {
            cir.getReturnValue().setOnFireFor(100);
        }

        // Supercharge
        int j = EnchantmentHelper.getLevel(ExtraEnchantsMain.SUPERCHARGE, crossbow);
        if (j > 0 && !ExtraEnchantsMain.CONFIG.supercharge.effectsDisabled()) {
            cir.getReturnValue().setDamage(cir.getReturnValue().getDamage() + (double) j * 0.5 + 0.5);
            cir.getReturnValue().setPunch(j / 2);
        }
    }
}
