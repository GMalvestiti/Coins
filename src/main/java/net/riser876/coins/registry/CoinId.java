package net.riser876.coins.registry;

public enum CoinId {

    GOLD_COIN("gold_coin"),
    IRON_COIN("iron_coin"),
    COPPER_COIN("copper_coin");

    private final String id;

    CoinId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
