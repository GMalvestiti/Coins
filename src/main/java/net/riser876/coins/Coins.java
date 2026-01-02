package net.riser876.coins;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.util.CoinsGlobals;

@Mod(CoinsGlobals.MOD_ID)
public class Coins {

    public Coins(IEventBus modEventBus, ModContainer modContainer) {
        try {
            CoinsItem.init(modEventBus);
            CoinsGlobals.LOGGER.info("[Coins] Mod loaded.");
        } catch (Exception e) {
            CoinsGlobals.LOGGER.error("[Coins] Failed to load.", e);
        }
    }
}
