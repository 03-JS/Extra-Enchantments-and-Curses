package net.fabricmc.extraenchantments;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.extraenchantments.curses.*;
import net.fabricmc.extraenchantments.enchantments.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraEnchantsMain implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("extra_enchants");
    private static final Enchantment HEALTH_FOR_BLOOD = new HealthForBlood(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment ILLAGERS_BANE = new IllagersBane(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment FISHERMANS_BLADE = new FishermansBlade(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment FREEZING_ASPECT = new FreezingAspect(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment LEVITATIONAL_SHOT = new LevitationalShot(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    private static final Enchantment BURNING_THORNS = new BurningThorns(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST});
    private static final Enchantment FREEZING_THORNS = new FreezingThorns(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST});
    private static final Enchantment SPECTRAL_VISION = new SpectralVision(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD});
    private static final Enchantment FRENZY = new Frenzy(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment GUARDING_STRIKE = new GuardingStrike(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment PAIN_CYCLE = new PainCycle(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment CURSE_OF_ZEUS = new CurseOfZeus(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    private static final Enchantment ELECTRIFIED = new Electrified(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_BLINDNESS = new CurseOfBlindness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment CURSE_OF_WITHERING = new CurseOfWithering(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_UNDEAD = new CurseOfUndead(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_NAUSEA = new CurseOfNausea(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment CURSE_OF_SLOWNESS = new CurseOfSlowness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.FEET});
    private static final Enchantment CURSE_OF_INCOMPATIBILITY = new CurseOfIncompatibility(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    private static final Enchantment ELECTRIFYING_SHOT = new ElectrifyingShot(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    private static final Enchantment RESONATING_SHOT = new ResonatingShot(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    private static final Enchantment SHADOW_SHOT = new ShadowShot(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    private static final Enchantment HOT_SHOT = new HotShot(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment CURSE_OF_WEAKNESS = new CurseOfWeakness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    private static final Enchantment ENIGMA_RESONATOR = new EnigmaResonator(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    private static final Enchantment PROJECTILES_OVERCHARGE = new ProjectilesOvercharge(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.LEGS});
    private static final Enchantment SUPERCHARGE = new Supercharge(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "health_for_blood"), HEALTH_FOR_BLOOD);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "frenzy"), FRENZY);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "guarding_strike"), GUARDING_STRIKE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "pain_cycle"), PAIN_CYCLE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "freezing_aspect"), FREEZING_ASPECT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "illagers_bane"), ILLAGERS_BANE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "fishermans_blade"), FISHERMANS_BLADE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "enigma_resonator"), ENIGMA_RESONATOR);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "burning_thorns"), BURNING_THORNS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "freezing_thorns"), FREEZING_THORNS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "projectiles_overcharge"), PROJECTILES_OVERCHARGE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "spectral_vision"), SPECTRAL_VISION);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "electrified"), ELECTRIFIED);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "electrifying_shot"), ELECTRIFYING_SHOT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "resonating_shot"), RESONATING_SHOT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "shadow_shot"), SHADOW_SHOT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "levitational_shot"), LEVITATIONAL_SHOT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "hot_shot"), HOT_SHOT);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "supercharge"), SUPERCHARGE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "zeus_curse"), CURSE_OF_ZEUS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "blindness_curse"), CURSE_OF_BLINDNESS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "withering_curse"), CURSE_OF_WITHERING);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "nausea_curse"), CURSE_OF_NAUSEA);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "weakness_curse"), CURSE_OF_WEAKNESS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "incompatibility_curse"), CURSE_OF_INCOMPATIBILITY);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "slowness_curse"), CURSE_OF_SLOWNESS);
        Registry.register(Registry.ENCHANTMENT, new Identifier("extra_enchantments", "undead_curse"), CURSE_OF_UNDEAD);
    }
}
