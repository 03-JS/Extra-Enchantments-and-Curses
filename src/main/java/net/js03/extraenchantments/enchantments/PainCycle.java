package net.js03.extraenchantments.enchantments;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.TraderLlama;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PainCycle extends Enchantment {

    private int hits;

    public PainCycle(Rarity weight, EnchantmentCategory type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        hits = 0;
    }

    @Override
    public int getMinCost(int level) {
        return 5 + (level - 1) * 9;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean checkCompatibility(Enchantment pOther) {
        return !(pOther instanceof Frenzy) && !(pOther instanceof HealthForBlood) && !(pOther instanceof GuardingStrike);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return super.canEnchant(pStack) || pStack.getItem() instanceof AxeItem;
    }

//    @Override
//    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
//        if (pTarget instanceof Monster || pTarget instanceof Player || pTarget instanceof Hoglin || pTarget instanceof Bee
//                || pTarget instanceof Dolphin || pTarget instanceof Goat || pTarget instanceof IronGolem || pTarget instanceof SnowGolem || pTarget instanceof Llama
//                || pTarget instanceof TraderLlama || pTarget instanceof Panda || pTarget instanceof PolarBear || pTarget instanceof Wolf
//                || pTarget instanceof Pufferfish || pTarget instanceof Slime || pTarget instanceof MagmaCube || pTarget instanceof Phantom
//                || pTarget instanceof EnderDragon) {
//            if (!((LivingEntity) pTarget).getLastDamageSource().is(DamageTypeTags.IS_PROJECTILE)) {
//                if (hits >= 7) {
//                    if (((LivingEntity) pTarget).getLastDamageSource() != null) {
//                        pTarget.hurt(pAttacker.damageSources().magic(), 20);
//                        pAttacker.level().playSound(null, pTarget.blockPosition(), SoundEvents.ARROW_HIT_PLAYER, SoundSource.MASTER, 1f, 1f);
//                        hits = 0;
//                    }
//                } else {
//                    hits++;
//                    if (pAttacker.getHealth() < 1) {
//                        pAttacker.hurt(pAttacker.damageSources().magic(), 100);
//                    } else {
//                        pAttacker.setHealth(pAttacker.getHealth() - 0.5f);
//                    }
//                    pAttacker.level().playSound(null, pAttacker.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.MASTER, 3f, 1f);
//                }
//            }
//        }
//    }
}
