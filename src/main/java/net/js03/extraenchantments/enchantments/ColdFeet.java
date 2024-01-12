package net.js03.extraenchantments.enchantments;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.js03.extraenchantments.config.ConfigUtils;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ColdFeet extends Enchantment {

    public ColdFeet(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, ExtraEnchantsMain.CONFIG.coldFeet.target(), slotTypes);
    }

    public int getMinPower(int level) {
        return 20;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    public boolean isTreasure() {
        return ExtraEnchantsMain.CONFIG.coldFeet.isTreasure();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ExtraEnchantsMain.CONFIG.coldFeet.isAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ExtraEnchantsMain.CONFIG.coldFeet.isAvailableForRandomSelection();
    }

    public int getMaxLevel() {
        return ExtraEnchantsMain.CONFIG.coldFeet.maxLevel();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return ConfigUtils.checkAcceptableItems("Cold Feet", stack, target);
    }

    public static void freezeWater(LivingEntity entity, World world, BlockPos blockPos) {
        if (entity.isOnGround()) {
            BlockState blockState = Blocks.FROSTED_ICE.getDefaultState();
            int i = Math.min(16, 2);
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-i, -1, -i), blockPos.add(i, -1, i))) {
                BlockState blockState3;
                if (!blockPos2.isWithinDistance(entity.getPos(), (double)i)) continue;
                mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
                BlockState blockState2 = world.getBlockState(mutable);
                if (!blockState2.isAir() || (blockState3 = world.getBlockState(blockPos2)) != FrostedIceBlock.getMeltedState() || !blockState.canPlaceAt(world, blockPos2) || !world.canPlace(blockState, blockPos2, ShapeContext.absent())) continue;
                world.setBlockState(blockPos2, blockState);
                world.scheduleBlockTick(blockPos2, Blocks.FROSTED_ICE, MathHelper.nextInt(entity.getRandom(), 60, 120));
            }
        }
    }

    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.DEPTH_STRIDER && other != Enchantments.FROST_WALKER && !(other instanceof HellWalker);
    }
}
