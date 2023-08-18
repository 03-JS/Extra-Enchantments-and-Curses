package net.js03.extraenchantments.enchantments;


import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class IllagersBane extends Enchantment {

    public IllagersBane(Rarity weight, EnchantmentCategory type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return mobType == MobType.ILLAGER ? level * 2.5F : 0;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinCost(int level) {
        return 1 + (level - 1) * 8;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 20;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return super.checkCompatibility(pOther) && !(pOther instanceof DamageEnchantment);
    }
}
