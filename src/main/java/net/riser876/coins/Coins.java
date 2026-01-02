package net.riser876.coins;

import net.fabricmc.api.ModInitializer;
import net.riser876.coins.registry.CoinsItem;
import net.riser876.coins.util.CoinsGlobals;

public class Coins implements ModInitializer {

    @Override
    public void onInitialize() {
        try {
            CoinsItem.init();
            CoinsGlobals.LOGGER.info("[Coins] Mod loaded.");
        } catch (Exception e) {
            CoinsGlobals.LOGGER.error("[Coins] Failed to load.", e);
        }
    }
}
