package net.js03.extraenchantments;

import net.fabricmc.api.ModInitializer;
import net.js03.extraenchantments.config.ExtraEnchantsConfig;
import net.js03.extraenchantments.curses.*;
import net.js03.extraenchantments.enchantments.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtraEnchantsMain implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("extra_enchants");
    public static final ExtraEnchantsConfig CONFIG = ExtraEnchantsConfig.createAndLoad();

    public static final Enchantment HEALTH_FOR_BLOOD = new HealthForBlood(CONFIG.lifesteal.weight(), CONFIG.lifesteal.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment ILLAGERS_BANE = new IllagersBane(CONFIG.illagersBane.weight(), CONFIG.illagersBane.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment FISHERMANS_BLADE = new FishermansBlade(CONFIG.fishermansBlade.weight(), CONFIG.fishermansBlade.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment FREEZING_ASPECT = new FreezingAspect(CONFIG.freezingAspect.weight(), CONFIG.freezingAspect.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment LEVITATIONAL_SHOT = new LevitationalShot(CONFIG.levitationalShot.weight(), CONFIG.levitationalShot.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment BURNING_THORNS = new BurningThorns(CONFIG.burningThorns.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST});
    public static final Enchantment FREEZING_THORNS = new FreezingThorns(CONFIG.freezingThorns.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST});
    public static final Enchantment ICE_PROTECTION = new IceProtection(CONFIG.iceProtection.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    public static final Enchantment HELLWALKER = new HellWalker(CONFIG.hellwalker.weight(), new EquipmentSlot[]{EquipmentSlot.FEET});
    public static final Enchantment COLD_FEET = new ColdFeet(CONFIG.coldFeet.weight(), new EquipmentSlot[]{EquipmentSlot.FEET});
    public static final Enchantment SPECTRAL_VISION = new SpectralVision(CONFIG.spectralVision.weight(), new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment FRENZY = new Frenzy(CONFIG.frenzy.weight(), CONFIG.frenzy.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment GUARDING_STRIKE = new GuardingStrike(CONFIG.guardingStrike.weight(), CONFIG.guardingStrike.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment PAIN_CYCLE = new PainCycle(CONFIG.painCycle.weight(), CONFIG.painCycle.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment SOUL_REAPER = new SoulReaper(CONFIG.soulReaper.weight(), CONFIG.soulReaper.target(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment CURSE_OF_ZEUS = new CurseOfZeus(CONFIG.curseOfZeus.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment ELECTRIFIED = new Electrified(CONFIG.electrified.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_BLINDNESS = new CurseOfBlindness(CONFIG.curseOfBlindness.weight(), new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment CURSE_OF_WITHERING = new CurseOfWithering(CONFIG.curseOfWithering.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_UNDEAD = new CurseOfUndead(CONFIG.curseOfUndead.weight(), new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment CURSE_OF_NAUSEA = new CurseOfNausea(CONFIG.curseOfNausea.weight(), new EquipmentSlot[]{EquipmentSlot.HEAD});
    public static final Enchantment CURSE_OF_SLOWNESS = new CurseOfSlowness(CONFIG.curseOfSlowness.weight(), new EquipmentSlot[]{EquipmentSlot.FEET});
    public static final Enchantment CURSE_OF_INCOMPATIBILITY = new CurseOfIncompatibility(CONFIG.curseOfIncompatibility.weight(), new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment ELECTRIFYING_SHOT = new ElectrifyingShot(CONFIG.electrifyingShot.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment RESONATING_SHOT = new ResonatingShot(CONFIG.resonatingShot.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment SHADOW_SHOT = new ShadowShot(CONFIG.shadowShot.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment HOT_SHOT = new HotShot(CONFIG.incandescent.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment ECHO = new Echo(CONFIG.echo.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment CURSE_OF_WEAKNESS = new CurseOfWeakness(CONFIG.curseOfWeakness.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS});
    public static final Enchantment ENIGMA_RESONATOR = new EnigmaResonator(CONFIG.enigmaResonator.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment TARGET_LOCK = new TargetLock(CONFIG.targetLock.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment SUPERCHARGE = new Supercharge(CONFIG.supercharge.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    public static final Enchantment REACH = new Reach(CONFIG.reach.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment SWIFTNESS = new Swiftness(CONFIG.swiftness.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment CURSE_OF_ATTRITION = new CurseOfAttrition(CONFIG.curseOfAttrition.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment OVERSHIELD = new Overshield(CONFIG.overshield.weight(), new EquipmentSlot[]{EquipmentSlot.CHEST});
    public static final Enchantment EXPERIENCE_CATALYST = new ExperienceCatalyst(CONFIG.xpCatalyst.weight(), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    public static final Enchantment ENERGIZED = new Energized(CONFIG.energized.weight(), new EquipmentSlot[]{EquipmentSlot.LEGS});
    public static final Enchantment CURSE_OF_FRAGILITY = new CurseOfFragility(CONFIG.energized.weight(), new EquipmentSlot[]{EquipmentSlot.LEGS});


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "lifesteal"), HEALTH_FOR_BLOOD);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "frenzy"), FRENZY);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "guarding_strike"), GUARDING_STRIKE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "pain_cycle"), PAIN_CYCLE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "soul_reaper"), SOUL_REAPER);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "freezing_aspect"), FREEZING_ASPECT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "illagers_bane"), ILLAGERS_BANE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "fishermans_blade"), FISHERMANS_BLADE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "enigma_resonator"), ENIGMA_RESONATOR);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "reach"), REACH);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "swiftness"), SWIFTNESS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "experience_catalyst"), EXPERIENCE_CATALYST);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "burning_thorns"), BURNING_THORNS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "ice_protection"), ICE_PROTECTION);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "freezing_thorns"), FREEZING_THORNS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "overshield"), OVERSHIELD);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "hellwalker"), HELLWALKER);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "spectral_vision"), SPECTRAL_VISION);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "electrified"), ELECTRIFIED);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "energized"), ENERGIZED);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "cold_feet"), COLD_FEET);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "electrifying_shot"), ELECTRIFYING_SHOT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "resonating_shot"), RESONATING_SHOT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "shadow_shot"), SHADOW_SHOT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "echo"), ECHO);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "levitational_shot"), LEVITATIONAL_SHOT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "incandescent"), HOT_SHOT);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "supercharge"), SUPERCHARGE);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "target_lock"), TARGET_LOCK);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "zeus_curse"), CURSE_OF_ZEUS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "blindness_curse"), CURSE_OF_BLINDNESS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "withering_curse"), CURSE_OF_WITHERING);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "nausea_curse"), CURSE_OF_NAUSEA);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "weakness_curse"), CURSE_OF_WEAKNESS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "incompatibility_curse"), CURSE_OF_INCOMPATIBILITY);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "fragility_curse"), CURSE_OF_FRAGILITY);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "slowness_curse"), CURSE_OF_SLOWNESS);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "undead_curse"), CURSE_OF_UNDEAD);
        Registry.register(Registries.ENCHANTMENT, new Identifier("extra_enchantments", "attrition_curse"), CURSE_OF_ATTRITION);
    }
}
