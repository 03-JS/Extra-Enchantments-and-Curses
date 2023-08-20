package net.js03.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;;

public class BurningThorns extends Enchantment {
    public BurningThorns(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 11 + 21 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 51;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.THORNS;
    }

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        int rng = (int) (1 + Math.random() * 4);
        if (attacker instanceof LivingEntity && rng <= level && !attacker.isOnFire()) {
            attacker.setOnFireFor(3);
        }
    }

}
