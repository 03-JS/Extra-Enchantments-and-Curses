package net.fabricmc.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.TagKey;

public class ElectrifyingShot extends Enchantment {
    public ElectrifyingShot(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.BOW, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return other != Enchantments.QUICK_CHARGE && other != Enchantments.PIERCING && other != Enchantments.MULTISHOT && !(other instanceof HotShot) && !(other instanceof LevitationalShot) && !(other instanceof Supercharge);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int rng = (int) (Math.random() * 11);
        if (target instanceof LivingEntity && ((LivingEntity) target).getRecentDamageSource() != null) {
            if (((LivingEntity) target).getRecentDamageSource().isIn(DamageTypeTags.IS_PROJECTILE) && user.getWorld().isThundering()) {
                if (rng <= 2) {
                    LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.getWorld());
                    assert lightningEntity != null;
                    lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                    target.getWorld().spawnEntity(lightningEntity);
                }
            }
        }
    }

}
