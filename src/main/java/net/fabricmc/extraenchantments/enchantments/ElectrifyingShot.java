package net.fabricmc.extraenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;

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
            if (((LivingEntity) target).getRecentDamageSource().isProjectile() && user.world.isThundering()) {
                if (rng <= 2) {
                    LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.world);
                    assert lightningEntity != null;
                    lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
                    target.world.spawnEntity(lightningEntity);
                }
            }
        }
    }

}
