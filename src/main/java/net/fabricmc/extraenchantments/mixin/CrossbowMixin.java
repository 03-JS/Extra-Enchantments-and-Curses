package net.fabricmc.extraenchantments.mixin;

import net.fabricmc.extraenchantments.ExtraEnchantsMain;
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
        int j = EnchantmentHelper.getLevel(ExtraEnchantsMain.HOT_SHOT, crossbow);
        if (j > 0) {
            cir.getReturnValue().setOnFireFor(100);
        }
        int k = EnchantmentHelper.getLevel(ExtraEnchantsMain.SUPERCHARGE, crossbow);
        if (k > 0) {
            cir.getReturnValue().setDamage(cir.getReturnValue().getDamage() + (double) k * 0.5 + 0.5);
            cir.getReturnValue().setPunch(k / 2);
        }
    }
}
