package net.fabricmc.extraenchantments.enchantments;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class EnigmaResonator extends Enchantment {
    public EnigmaResonator(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.DIGGER, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof PainCycle) && !(other instanceof HealthForBlood) && !(other instanceof Frenzy) && !(other instanceof GuardingStrike);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            int rng = (int) (Math.random() * 35);
            if (rng <= level) {
                if (((LivingEntity) target).getDamageTracker().getMostRecentDamage() != null) {
                    target.damage(DamageSource.GENERIC, (float) (user.getHealth() * 0.5) + ((LivingEntity) target).getDamageTracker().getMostRecentDamage().getDamage());
                }
            }
        }
    }
}
