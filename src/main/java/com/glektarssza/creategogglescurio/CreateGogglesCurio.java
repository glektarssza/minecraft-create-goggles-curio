package com.glektarssza.creategogglescurio;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;

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
        GoggleOverlayRenderer.registerCustomGoggleCondition(new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return GogglesInCurioSlot();
            }
        });
    }

    public boolean GogglesInCurioSlot() {
        Minecraft mc = Minecraft.getInstance();
        LivingEntity player = mc.player;
        ICuriosHelper helper = CuriosApi.getCuriosHelper();
        return helper.findCurio(player, "head", 0)
                .map((slotResult) -> slotResult.getStack().getItem() instanceof GogglesItem)
                .orElse(false);
    }
}
