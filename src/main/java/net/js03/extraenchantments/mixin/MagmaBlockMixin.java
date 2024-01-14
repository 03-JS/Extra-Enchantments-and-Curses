package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MagmaBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MagmaBlock.class)
public class MagmaBlockMixin extends Block {

    public MagmaBlockMixin(Settings settings) {
        super(settings);
    }

    /**
     * @author JS03
     * @reason Modifying the onSteppedOn method so I can add an if statement
     */
    @Overwrite
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (!entity.bypassesSteppingEffects() && !EnchantmentHelper.hasFrostWalker((LivingEntity) entity) && EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HELLWALKER, (LivingEntity) entity) <= 0) {
                entity.damage(world.getDamageSources().hotFloor(), 1.0f);
            } else if (EnchantmentHelper.getEquipmentLevel(ExtraEnchantsMain.HELLWALKER, (LivingEntity) entity) != 0) {
                if (ExtraEnchantsMain.CONFIG.hellwalker.effectsDisabled()) {
                    entity.damage(world.getDamageSources().hotFloor(), 1.0f);
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
