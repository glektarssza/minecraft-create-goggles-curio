package com.glektarssza.creategogglescurio;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simibubi.create.content.contraptions.goggles.GogglesItem;
import com.simibubi.create.content.contraptions.goggles.GoggleOverlayRenderer;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.util.ICuriosHelper;

/**
 * The root mod class.
 */
@Mod(CreateGogglesCurio.MOD_ID)
public class CreateGogglesCurio {
    /**
     * The ID of the mod.
     */
    public static final String MOD_ID = "creategogglescurio";

    /**
     * The logger to use for the mod.
     */
    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * Create a new instance.
     */
    public CreateGogglesCurio() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::Init);
    }

    /**
     * Initialize the mod.
     *
     * @param event The event to handle.
     */
    public void Init(FMLCommonSetupEvent event) {
        LOGGER.info("Initializing CreateGogglesCurio...");
        if (!ForgeRegistries.ITEMS.containsKey(new ResourceLocation("create", "goggles"))) {
            LOGGER.error("Could not find Create Engineer's Goggles, is Create is installed?");
            LOGGER.error("Disabling CreateGogglesCurio!");
            return;
        }
        GoggleOverlayRenderer.registerCustomGoggleCondition(new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return AreGogglesInCurioSlot();
            }
        });
        LOGGER.info("Finished initializing CreateGogglesCurio!");
    }

    /**
     * Check if the player has the Engineer's Goggles from Create in the "head"
     * curio slot.
     *
     * @return `true` if the player has the Engineer's Goggles from Create in
     *         the "head" curio slot; `false` otherwise.
     */
    public boolean AreGogglesInCurioSlot() {
        Minecraft mc = Minecraft.getInstance();
        LivingEntity player = mc.player;
        ICuriosHelper helper = CuriosApi.getCuriosHelper();
        return helper.findCurio(player, "head", 0)
                .map((slotResult) -> slotResult.getStack().getItem() instanceof GogglesItem)
                .orElse(false);
    }
}
