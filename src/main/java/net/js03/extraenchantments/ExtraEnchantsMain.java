package net.js03.extraenchantments;

import com.mojang.logging.LogUtils;
import net.js03.extraenchantments.curses.*;
import net.js03.extraenchantments.enchantments.*;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExtraEnchantsMain.MOD_ID)
public class ExtraEnchantsMain
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "extra_enchantments";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);
    public static final RegistryObject<Enchantment> LIFESTEAL = ENCHANTMENTS.register("lifesteal", () -> new HealthForBlood(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> FRENZY = ENCHANTMENTS.register("frenzy", () -> new Frenzy(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> GUARDING_STRIKE = ENCHANTMENTS.register("guarding_strike", () -> new GuardingStrike(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> PAIN_CYCLE = ENCHANTMENTS.register("pain_cycle", () -> new PainCycle(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> SOUL_REAPER = ENCHANTMENTS.register("soul_reaper", () -> new SoulReaper(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> FREEZING_ASPECT = ENCHANTMENTS.register("freezing_aspect", () -> new FreezingAspect(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> ILLAGERS_BANE = ENCHANTMENTS.register("illagers_bane", () -> new IllagersBane(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> FISHERMANS_BLADE = ENCHANTMENTS.register("fishermans_blade", () -> new FishermansBlade(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> ENIGMA_RESONATOR = ENCHANTMENTS.register("enigma_resonator", () -> new EnigmaResonator(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> REACH = ENCHANTMENTS.register("reach", () -> new Reach(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> SWIFTNESS = ENCHANTMENTS.register("swiftness", () -> new Swiftness(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> EXPERIENCE_CATALYST = ENCHANTMENTS.register("experience_catalyst", () -> new ExperienceCatalyst(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    public static final RegistryObject<Enchantment> BURNING_THORNS = ENCHANTMENTS.register("burning_thorns", () -> new BurningThorns(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST}));
    public static final RegistryObject<Enchantment> FREEZING_THORNS = ENCHANTMENTS.register("freezing_thorns", () -> new FreezingThorns(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST}));
    public static final RegistryObject<Enchantment> OVERSHIELD = ENCHANTMENTS.register("overshield", () -> new Overshield(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST}));
    public static final RegistryObject<Enchantment> HELLWALKER = ENCHANTMENTS.register("hellwalker", () -> new HellWalker(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.FEET}));
    public static final RegistryObject<Enchantment> SPECTRAL_VISION = ENCHANTMENTS.register("spectral_vision", () -> new SpectralVision(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD}));
    public static final RegistryObject<Enchantment> ELECTRIFIED = ENCHANTMENTS.register("electrified", () -> new Electrified(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS}));
    public static final RegistryObject<Enchantment> ELECTRIFYING_SHOT = ENCHANTMENTS.register("electrifying_shot", () -> new ElectrifyingShot(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> RESONATING_SHOT = ENCHANTMENTS.register("resonating_shot", () -> new ResonatingShot(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> SHADOW_SHOT = ENCHANTMENTS.register("shadow_shot", () -> new ShadowShot(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> LEVITATIONAL_SHOT = ENCHANTMENTS.register("levitational_shot", () -> new LevitationalShot(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> HOT_SHOT = ENCHANTMENTS.register("incandescent", () -> new HotShot(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> SUPERCHARGE = ENCHANTMENTS.register("supercharge", () -> new Supercharge(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> TARGET_LOCK = ENCHANTMENTS.register("target_lock", () -> new TargetLock(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> CURSE_OF_ZEUS = ENCHANTMENTS.register("zeus_curse", () -> new CurseOfZeus(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS}));
    public static final RegistryObject<Enchantment> CURSE_OF_BLINDNESS = ENCHANTMENTS.register("blindness_curse", () -> new CurseOfBlindness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD}));
    public static final RegistryObject<Enchantment> CURSE_OF_WITHERING = ENCHANTMENTS.register("withering_curse", () -> new CurseOfWithering(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS}));
    public static final RegistryObject<Enchantment> CURSE_OF_NAUSEA = ENCHANTMENTS.register("nausea_curse", () -> new CurseOfNausea(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD}));
    public static final RegistryObject<Enchantment> CURSE_OF_WEAKNESS = ENCHANTMENTS.register("weakness_curse", () -> new CurseOfWeakness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS}));
    public static final RegistryObject<Enchantment> CURSE_OF_INCOMPATIBILITY = ENCHANTMENTS.register("incompatibility_curse", () -> new CurseOfIncompatibility(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.HEAD, EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}));
    public static final RegistryObject<Enchantment> CURSE_OF_SLOWNESS = ENCHANTMENTS.register("slowness_curse", () -> new CurseOfSlowness(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.FEET}));
    public static final RegistryObject<Enchantment> CURSE_OF_UNDEAD = ENCHANTMENTS.register("undead_curse", () -> new CurseOfUndead(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.HEAD}));
    public static final RegistryObject<Enchantment> CURSE_OF_ATTRITION = ENCHANTMENTS.register("attrition_curse", () -> new CurseOfAttrition(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));


    public ExtraEnchantsMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        ENCHANTMENTS.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
