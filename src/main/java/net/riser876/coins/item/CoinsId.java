package net.riser876.coins.item;

public enum CoinsId {

    GOLD_COIN("gold_coin"),
    IRON_COIN("iron_coin"),
    COPPER_COIN("copper_coin");

    private final String id;

    CoinsId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
