package net.fabricmc.extraenchantments.curses;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;

public class CurseOfZeus extends Enchantment {
    public CurseOfZeus(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.WEARABLE, slotTypes);
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasure() {
        return true;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getWorld().isRaining() || user.getWorld().isThundering()) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(user.getWorld());
            assert lightningEntity != null;
            lightningEntity.refreshPositionAfterTeleport(user.getX(), user.getY(), user.getZ());
            user.getWorld().spawnEntity(lightningEntity);
        }
    }
}
