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
