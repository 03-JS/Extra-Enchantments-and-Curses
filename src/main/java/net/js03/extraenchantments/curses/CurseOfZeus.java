package net.js03.extraenchantments.curses;


import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseOfZeus extends Enchantment {
    public CurseOfZeus(Rarity weight, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentCategory.WEARABLE, slotTypes);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public int getMinCost(int level) {
        return 25;
    }

    public int getMaxCost(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (pTarget.level().isRaining() || pTarget.level().isThundering()) {
            LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(pTarget.level());
            assert lightningEntity != null;
            lightningEntity.moveTo(pTarget.getX(), pTarget.getY(), pTarget.getZ());
            pTarget.level().addFreshEntity(lightningEntity);
        }
    }
}
