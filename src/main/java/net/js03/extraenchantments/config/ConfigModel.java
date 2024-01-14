package net.js03.extraenchantments.config;

import io.wispforest.owo.config.annotation.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

@Modmenu(modId = "extra-enchantments-and-curses")
@Config(name = "extra-enchantments-and-curses-config", wrapperName = "ExtraEnchantsConfig")
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
        @RestartRequired
        public Enchantment.Rarity weight;
        public boolean effectsDisabled;

        public EnchantmentOptions(int maxLevel, boolean isTreasure, boolean isAvailableForEnchantedBookOffer, boolean isAvailableForRandomSelection, EnchantmentTarget target, ItemOptions acceptableItems, Enchantment.Rarity weight, boolean effectsDisabled) {
            this.maxLevel = maxLevel;
            this.isTreasure = isTreasure;
            this.isAvailableForEnchantedBookOffer = isAvailableForEnchantedBookOffer;
            this.isAvailableForRandomSelection = isAvailableForRandomSelection;
            this.target = target;
            this.acceptableItems = acceptableItems;
            this.weight = weight;
            this.effectsDisabled = effectsDisabled;
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
            new ItemOptions(true, false, false, false, false, false, false, false, false, false, false), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions coldFeet = new EnchantmentOptions(2, true, true, true, EnchantmentTarget.ARMOR_FEET,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions electrified = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions electrifyingShot = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.BOW,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions energized = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_LEGS,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions enigmaResonator = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions xpCatalyst = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.FISHING_ROD,
            new ItemOptions(false, true, true, true, true, true, false, false, false, true, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions fishermansBlade = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(), Enchantment.Rarity.UNCOMMON, false);
    @Nest
    public EnchantmentOptions freezingAspect = new EnchantmentOptions(2, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions freezingThorns = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.ARMOR_CHEST,
            new ItemOptions(true, false, false, false, false, false, false, false, false, false, false), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions frenzy = new EnchantmentOptions(2, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions guardingStrike = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions lifesteal = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions painCycle = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions soulReaper = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, false, false, false, false, false, false, false, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions hellwalker = new EnchantmentOptions(1, true, false, false, EnchantmentTarget.ARMOR_FEET,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions incandescent = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.CROSSBOW,
            new ItemOptions(), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions iceProtection = new EnchantmentOptions(4, false, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.UNCOMMON, false);
    @Nest
    public EnchantmentOptions levitationalShot = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.CROSSBOW,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions illagersBane = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(), Enchantment.Rarity.UNCOMMON, false);
    @Nest
    public EnchantmentOptions overshield = new EnchantmentOptions(5, true, false, false, EnchantmentTarget.ARMOR_CHEST,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions reach = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.DIGGER,
            new ItemOptions(false, true, false, false, false, false, false, false, false, true, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions swiftness = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, true, true, true, false, false, false, true, false), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions resonatingShot = new EnchantmentOptions(3, false, true, true, EnchantmentTarget.BOW,
            new ItemOptions(), Enchantment.Rarity.RARE, false);
    @Nest
    public EnchantmentOptions shadowShot = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.BOW,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions spectralVision = new EnchantmentOptions(1, false, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions supercharge = new EnchantmentOptions(5, false, true, true, EnchantmentTarget.CROSSBOW,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions targetLock = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.CROSSBOW,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions echo = new EnchantmentOptions(4, false, true, true, EnchantmentTarget.BOW,
            new ItemOptions(), Enchantment.Rarity.COMMON, false);


    @SectionHeader("Curses")
    @Nest
    public EnchantmentOptions curseOfAttrition = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.WEAPON,
            new ItemOptions(false, false, true, true, true, true, false, false, false, true, false), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfBlindness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfIncompatibility = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.BREAKABLE,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfNausea = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfSlowness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_FEET,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfUndead = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR_HEAD,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfWeakness = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfWithering = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
    @Nest
    public EnchantmentOptions curseOfZeus = new EnchantmentOptions(1, true, true, true, EnchantmentTarget.ARMOR,
            new ItemOptions(), Enchantment.Rarity.VERY_RARE, false);
}
