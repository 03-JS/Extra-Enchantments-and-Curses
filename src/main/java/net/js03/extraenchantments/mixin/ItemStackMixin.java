package net.js03.extraenchantments.mixin;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    public ItemStackMixin() {
    }



    @Shadow public abstract int getMaxDamage();

    @Shadow public abstract Item getItem();

    @Shadow public abstract boolean isDamageable();

    @Shadow public abstract int getDamage();

    @Shadow public abstract void setDamage(int damage);

    /**
     * @author JS03
     * @reason To add an if statement
     */
    @Overwrite
    public boolean damage(int amount, Random random, @Nullable ServerPlayerEntity player) {
        if (!this.isDamageable()) {
            return false;
        } else {
            int i;
            if (amount > 0) {
                i = EnchantmentHelper.getLevel(Enchantments.UNBREAKING, ((ItemStack) (Object) this));
                int j = 0;

                for(int k = 0; i > 0 && k < amount; ++k) {
                    if (UnbreakingEnchantment.shouldPreventDamage(((ItemStack) (Object) this), i, random)) {
                        ++j;
                    }
                }

                amount -= j;

                int z = EnchantmentHelper.getLevel(ExtraEnchantsMain.CURSE_OF_FRAGILITY, ((ItemStack) (Object) this));
                if (z > 0 && !ExtraEnchantsMain.CONFIG.curseOfFragility.effectsDisabled()) {
                    amount += ThreadLocalRandom.current().nextInt(0, 34);
                }

                if (amount <= 0) {
                    return false;
                }
            }

            if (player != null && amount != 0) {
                Criteria.ITEM_DURABILITY_CHANGED.trigger(player, ((ItemStack) (Object) this), this.getDamage() + amount);
            }

            i = this.getDamage() + amount;
            this.setDamage(i);
            return i >= this.getMaxDamage();
        }
    }

}
