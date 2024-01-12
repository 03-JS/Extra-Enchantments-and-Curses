package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ExtraEnchantsConfig;
import net.js03.extraenchantments.enchantments.ColdFeet;
import net.js03.extraenchantments.enchantments.HellWalker;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow
    public abstract boolean addStatusEffect(StatusEffectInstance effect);
    @Shadow
    public abstract ItemStack getEquippedStack(EquipmentSlot var1);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "applyMovementEffects", at = @At("HEAD"))
    private void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        LivingEntity casted = (LivingEntity) (Object) this;
        int i = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HELLWALKER, casted);
        if (i > 0 && !ExtraEnchantsMain.CONFIG.hellwalker.effectsDisabled()) {
            HellWalker.freezeLava(casted, this.getWorld(), pos);
        }

        int j = EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.COLD_FEET, casted);
        if (j > 1 && !ExtraEnchantsMain.CONFIG.coldFeet.effectsDisabled()) {
            ColdFeet.freezeWater(casted, this.getWorld(), pos);
        }
    }

    /**
     * @author JS03
     * @reason I can't figure out how to use ModifyVariable properly, so I'm doing this instead (for now)
     */
    @Overwrite
    public boolean canFreeze() {
        if (this.isSpectator()) {
            return false;
        }
        boolean bl = !this.getEquippedStack(EquipmentSlot.HEAD).isIn(ItemTags.FREEZE_IMMUNE_WEARABLES) && !this.getEquippedStack(EquipmentSlot.CHEST).isIn(ItemTags.FREEZE_IMMUNE_WEARABLES) && !this.getEquippedStack(EquipmentSlot.LEGS).isIn(ItemTags.FREEZE_IMMUNE_WEARABLES) && !this.getEquippedStack(EquipmentSlot.FEET).isIn(ItemTags.FREEZE_IMMUNE_WEARABLES);
        if (!ExtraEnchantsMain.CONFIG.iceProtection.effectsDisabled()) {
            bl = bl && EnchantmentHelper.getLevel(ExtraEnchantsMain.ICE_PROTECTION, this.getEquippedStack(EquipmentSlot.HEAD)) < 4 || EnchantmentHelper.getLevel(ExtraEnchantsMain.ICE_PROTECTION, this.getEquippedStack(EquipmentSlot.CHEST)) < 4 || EnchantmentHelper.getLevel(ExtraEnchantsMain.ICE_PROTECTION, this.getEquippedStack(EquipmentSlot.LEGS)) < 4 || EnchantmentHelper.getLevel(ExtraEnchantsMain.ICE_PROTECTION, this.getEquippedStack(EquipmentSlot.FEET)) < 4;
        }
        return bl && super.canFreeze();
    }

}
