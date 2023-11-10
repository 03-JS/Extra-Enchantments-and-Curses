package net.js03.extraenchantments.config;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {

    public static boolean checkAcceptableItems(String enchantmentName, ItemStack stack, EnchantmentTarget target) {
        List<Boolean> itemTypeChecks = new ArrayList<>(List.of(false, false, false, false, false, false, false, false, false, false, false));
        switch (enchantmentName) {
            case "Burning Thorns" -> {
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Electrified" -> {
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrified.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Electrifying Shot" -> {
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.electrifyingShot.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Enigma Resonator" -> {
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.enigmaResonator.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Experience Catalyst" -> {
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.xpCatalyst.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Fishermans Blade" -> {
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.fishermansBlade.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Freezing Aspect" -> {
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingAspect.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Freezing Thorns" -> {
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.freezingThorns.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Frenzy" -> {
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.frenzy.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Guarding Strike" -> {
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.guardingStrike.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Lifesteal" -> {
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.lifesteal.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Pain Cycle" -> {
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.painCycle.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Soul Reaper" -> {
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.soulReaper.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Hellwalker" -> {
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.hellwalker.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Incandescent" -> {
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.incandescent.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Levitational Shot" -> {
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.levitationalShot.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Illagers Bane" -> {
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.illagersBane.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Overshield" -> {
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Reach" -> {
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.reach.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Swiftness" -> {
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.swiftness.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Resonating Shot" -> {
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.resonatingShot.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Shadow Shot" -> {
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.shadowShot.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Spectral Vision" -> {
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.spectralVision.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Supercharge" -> {
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.supercharge.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Target Lock" -> {
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.targetLock.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Attrition Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfAttrition.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Blindness Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfBlindness.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Incompat Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfIncompatibility.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Nausea Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfNausea.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Slowness Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfSlowness.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Undead Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfUndead.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Weakness Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWeakness.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Withering Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfWithering.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            case "Zeus Curse" -> {
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.armor()) {
                    itemTypeChecks.set(0, stack.getItem() instanceof ArmorItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.sword()) {
                    itemTypeChecks.set(1, stack.getItem() instanceof SwordItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.axe()) {
                    itemTypeChecks.set(2, stack.getItem() instanceof AxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.pickaxe()) {
                    itemTypeChecks.set(3, stack.getItem() instanceof PickaxeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.shovel()) {
                    itemTypeChecks.set(4, stack.getItem() instanceof ShovelItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.hoe()) {
                    itemTypeChecks.set(5, stack.getItem() instanceof HoeItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.fishingRod()) {
                    itemTypeChecks.set(6, stack.getItem() instanceof FishingRodItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.bow()) {
                    itemTypeChecks.set(7, stack.getItem() instanceof BowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.crossbow()) {
                    itemTypeChecks.set(8, stack.getItem() instanceof CrossbowItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.trident()) {
                    itemTypeChecks.set(9, stack.getItem() instanceof TridentItem);
                }
                if (ExtraEnchantsMain.CONFIG.curseOfZeus.acceptableItems.shears()) {
                    itemTypeChecks.set(10, stack.getItem() instanceof ShearsItem);
                }
            }
            default -> {}
        }

        return target.isAcceptableItem(stack.getItem()) || itemTypeChecks.get(0) || itemTypeChecks.get(1) || itemTypeChecks.get(2) || itemTypeChecks.get(3)
                || itemTypeChecks.get(4) || itemTypeChecks.get(5) || itemTypeChecks.get(6) || itemTypeChecks.get(7)
                || itemTypeChecks.get(8) || itemTypeChecks.get(9) || itemTypeChecks.get(10);
    }

}
