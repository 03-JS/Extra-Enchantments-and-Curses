package net.js03.extraenchantments.enchantments;



import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
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

import java.util.Random;

public class SoulReaper extends Enchantment {

//    private float percentage = 1f;
    private Random rng;

    public SoulReaper(Rarity weight, EnchantmentCategory type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        rng = new Random();
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return -2.0f;
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
        return !(pOther instanceof Frenzy) && !(pOther instanceof HealthForBlood) && !(pOther instanceof GuardingStrike) && !(pOther instanceof PainCycle);
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
////            float randomNumber = rng.nextFloat(0.03f, 0.06f);
//            float randomNumber = rng.nextFloat(0.5f, 2f);
////            percentage *= randomNumber;
//            int randomNumber1 = rng.nextInt(6);
//            if (randomNumber1 <= 1) {
//                pAttacker.level().playSound(null, pAttacker.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.MASTER, 3f, 1f);
//                pAttacker.heal(randomNumber /* * percentage */);
//            }
////            percentage = 1;
//        }
//    }
}
