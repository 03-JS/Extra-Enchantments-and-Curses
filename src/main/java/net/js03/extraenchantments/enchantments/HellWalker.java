package net.js03.extraenchantments.enchantments;


import net.minecraft.core.BlockPos;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

public class HellWalker extends Enchantment {

    public HellWalker(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.ARMOR_FEET, slotTypes);
    }

    @Override
    public int getDamageProtection(int pLevel, DamageSource pSource) {
        return pSource.is(DamageTypeTags.IS_FIRE) ? 12 : 0;
    }

    public int getMinCost(int level) {
        return 20;
    }

    public int getMaxCost(int level) {
        return this.getMinCost(level) + 15;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    public int getMaxLevel() {
        return 1;
    }

    public static void freezeLava(LivingEntity entity, Level world, BlockPos blockPos) {
        if (entity.onGround()) {
            BlockState blockState = Blocks.BASALT.defaultBlockState();
            int i = Math.min(16, 4);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

            for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.offset(-i, -1, -i), blockPos.offset(i, -1, i))) {
                if (blockPos2.closerThan(entity.blockPosition(), (double) i)) {
                    mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
                    BlockState blockState2 = world.getBlockState(mutable);
                    if (blockState2.isAir()) {
                        BlockState blockState3 = world.getBlockState(blockPos2);
                        if (blockState3.getBlock() == Blocks.LAVA && blockState3.getValue(LiquidBlock.LEVEL) == 0 && blockState.canSurvive(world, blockPos2) && world.isUnobstructed(blockState, blockPos2, CollisionContext.empty())) {
                            world.setBlockAndUpdate(blockPos2, blockState);
                            world.scheduleTick(blockPos2, Blocks.BASALT, Mth.nextInt(entity.getRandom(), 60, 120));
                        }
                    }
                }
            }

        }
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && pOther != Enchantments.DEPTH_STRIDER && pOther != Enchantments.FROST_WALKER;
    }
}
