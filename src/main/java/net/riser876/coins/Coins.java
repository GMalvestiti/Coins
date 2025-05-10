package net.riser876.coins;

import net.fabricmc.api.ModInitializer;
import net.riser876.coins.item.CoinItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Coins implements ModInitializer {

    public static final String MOD_ID = "coins";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        try {
            CoinItems.init();
            Coins.LOGGER.info("[Coins] Mod loaded.");
        } catch (Exception e) {
            Coins.LOGGER.error("[Coins] Failed to load.", e);
        }
    }
}
