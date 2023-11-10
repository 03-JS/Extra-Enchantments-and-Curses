package net.js03.extraenchantments.config;

import io.wispforest.owo.config.annotation.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

@Modmenu(modId = "extra-enchantments-and-curses")
@Config(name = "eec-config", wrapperName = "ExtraEnchantsConfig")
public class ConfigModel {
    public static class EnchantmentOptions {
        @RangeConstraint(min = 1, max = 10)
        public int maxLevel;
        public boolean isTreasure;
        public boolean isAvailableForEnchantedBookOffer;
        public boolean isAvailableForRandomSelection;
        @RestartRequired
        public EnchantmentTarget target;
        @Nest
        public ItemOptions acceptableItems;
        public Enchantment.Rarity weight;

        public EnchantmentOptions(int maxLevel, boolean isTreasure, boolean isAvailableForEnchantedBookOffer, boolean isAvailableForRandomSelection, EnchantmentTarget target, ItemOptions acceptableItems, Enchantment.Rarity weight) {
            this.maxLevel = maxLevel;
            this.isTreasure = isTreasure;
            this.isAvailableForEnchantedBookOffer = isAvailableForEnchantedBookOffer;
            this.isAvailableForRandomSelection = isAvailableForRandomSelection;
            this.target = target;
            this.acceptableItems = acceptableItems;
            this.weight = weight;
        }
    }

    public static class ItemOptions {
        public boolean armor;
        public boolean sword;
        public boolean axe;
        public boolean pickaxe;
        public boolean shovel;
        public boolean hoe;
        public boolean fishingRod;
        public boolean bow;
        public boolean crossbow;
        public boolean trident;
        public boolean shears;

        public ItemOptions() {
        }

        public ItemOptions(boolean armor, boolean sword, boolean axe, boolean pickaxe, boolean shovel, boolean hoe, boolean fishingRod, boolean bow, boolean crossbow, boolean trident, boolean shears) {
            this.armor = armor;
            this.sword = sword;
            this.axe = axe;
            this.pickaxe = pickaxe;
            this.shovel = shovel;
            this.hoe = hoe;
            this.fishingRod = fishingRod;
            this.bow = bow;
            this.crossbow = crossbow;
            this.trident = trident;
            this.shears = shears;
        }
    }

    @SectionHeader("Enchantments")
    @Nest
    public EnchantmentOptions burningThorns = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.ARMOR_CHEST,
            new ItemOptions(true, false, false, false, false, false, false, false, false, false, false), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions overshield = new EnchantmentOptions(5, true, false, false, EnchantmentTarget.ARMOR_CHEST,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);

    @SectionHeader("Curses")
    @Nest
    public EnchantmentOptions curseOfAttrition = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, true, true, true, false, false, false, true, false), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfBlindness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfIncompatibility = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.BREAKABLE,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfNausea = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfSlowness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_FEET,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfUndead = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfWeakness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfWithering = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
    @Nest
    public EnchantmentOptions curseOfZeus = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE);
}
