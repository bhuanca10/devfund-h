package org.minions.devfund.noemiguzman.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * class to create ships.
 */
final class ShipFactory {

    private static final Map<String, Supplier<Ship>> SHIP_FACTORY = new HashMap<>();
    static {
        SHIP_FACTORY.put("BattleShip", BattleShip::new);
        SHIP_FACTORY.put("BattleCruiser", BattleCruiser::new);
        SHIP_FACTORY.put("Cruiser", Cruiser::new);
        SHIP_FACTORY.put("LightCruiser", LightCruiser::new);
        SHIP_FACTORY.put("Destroyer", Destroyer::new);
        SHIP_FACTORY.put("Submarine", Submarine::new);
    }

    /**
     * private constructor.
     */
    private ShipFactory() {
    }

    /**
     * This method get the instance of specific class of ship.
     * @param shipType string type of ship.
     * @return specific ship instance.
     */
    static Ship getShip(final String shipType) {
        return SHIP_FACTORY.getOrDefault(shipType, EmptySea::new).get();
    }
}
