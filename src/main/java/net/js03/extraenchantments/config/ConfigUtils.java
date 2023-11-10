package net.js03.extraenchantments.config;

import net.js03.extraenchantments.ExtraEnchantsMain;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.*;

import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {

    public static boolean checkAcceptableItems(String enchantmentName, ItemStack stack, EnchantmentTarget target) {
        List<Boolean> itemTypeChecks = new ArrayList<>();
        switch (enchantmentName) {
            case "Burning Thorns":
                itemTypeChecks = new ArrayList<>();
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.armor()) {
                    itemTypeChecks.add(stack.getItem() instanceof ArmorItem); // 0
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.sword()) {
                    itemTypeChecks.add(stack.getItem() instanceof SwordItem); // 1
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.axe()) {
                    itemTypeChecks.add(stack.getItem() instanceof AxeItem); // 2
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.pickaxe()) {
                    itemTypeChecks.add(stack.getItem() instanceof PickaxeItem); // 3
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.shovel()) {
                    itemTypeChecks.add(stack.getItem() instanceof ShovelItem); // 4
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.hoe()) {
                    itemTypeChecks.add(stack.getItem() instanceof HoeItem); // 5
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.fishingRod()) {
                    itemTypeChecks.add(stack.getItem() instanceof FishingRodItem); // 6
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.bow()) {
                    itemTypeChecks.add(stack.getItem() instanceof BowItem); // 7
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.crossbow()) {
                    itemTypeChecks.add(stack.getItem() instanceof CrossbowItem); // 8
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.trident()) {
                    itemTypeChecks.add(stack.getItem() instanceof TridentItem); // 9
                }
                if (ExtraEnchantsMain.CONFIG.burningThorns.acceptableItems.shears()) {
                    itemTypeChecks.add(stack.getItem() instanceof ShearsItem); // 10
                }
                break;
            case "Overshield":
                itemTypeChecks = new ArrayList<>();
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.armor()) {
                    itemTypeChecks.add(stack.getItem() instanceof ArmorItem); // 0
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.sword()) {
                    itemTypeChecks.add(stack.getItem() instanceof SwordItem); // 1
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.axe()) {
                    itemTypeChecks.add(stack.getItem() instanceof AxeItem); // 2
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.pickaxe()) {
                    itemTypeChecks.add(stack.getItem() instanceof PickaxeItem); // 3
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.shovel()) {
                    itemTypeChecks.add(stack.getItem() instanceof ShovelItem); // 4
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.hoe()) {
                    itemTypeChecks.add(stack.getItem() instanceof HoeItem); // 5
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.fishingRod()) {
                    itemTypeChecks.add(stack.getItem() instanceof FishingRodItem); // 6
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.bow()) {
                    itemTypeChecks.add(stack.getItem() instanceof BowItem); // 7
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.crossbow()) {
                    itemTypeChecks.add(stack.getItem() instanceof CrossbowItem); // 8
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.trident()) {
                    itemTypeChecks.add(stack.getItem() instanceof TridentItem); // 9
                }
                if (ExtraEnchantsMain.CONFIG.overshield.acceptableItems.shears()) {
                    itemTypeChecks.add(stack.getItem() instanceof ShearsItem); // 10
                }
                break;
            default:
                ;
        }

        return target.isAcceptableItem(stack.getItem()) || itemTypeChecks.get(0) || itemTypeChecks.get(1) || itemTypeChecks.get(2) || itemTypeChecks.get(3)
                || itemTypeChecks.get(4) || itemTypeChecks.get(5) || itemTypeChecks.get(6) || itemTypeChecks.get(7)
                || itemTypeChecks.get(8) || itemTypeChecks.get(9) || itemTypeChecks.get(10);
    }

}
