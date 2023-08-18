package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public abstract class CrossbowMixin extends ProjectileWeaponItem implements Vanishable {

    public CrossbowMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "getArrow", at = @At("TAIL"))
    private static void getArrow(Level pLevel, LivingEntity pLivingEntity, ItemStack crossbow, ItemStack pAmmoStack, CallbackInfoReturnable<AbstractArrow> cir) {
        int j = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.HOT_SHOT.get(), crossbow);
        if (j > 0) {
            cir.getReturnValue().setSecondsOnFire(100);
        }
        int k = EnchantmentHelper.getTagEnchantmentLevel(ExtraEnchantsMain.SUPERCHARGE.get(), crossbow);
        if (k > 0) {
            cir.getReturnValue().setBaseDamage(cir.getReturnValue().getBaseDamage() + (double) k * 0.5 + 0.5);
            cir.getReturnValue().setKnockback(k / 2);
        }
    }
}
