package xyz.thegamecube.meatcooker;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps the raw fish type to the cooked fish type.
 *
 * @author SirFaizdat
 * @since 1.0
 */
final class FishRegistry {

    private Map<Byte, Byte> map;

    void init() {
        this.map = new HashMap<>();

        this.map.put((byte) 0, (byte) 0); // Normal fish
        this.map.put((byte) 1, (byte) 1); // Salmon
    }

    Byte getFood(Byte fish) {
        return map.get(fish);
    }

    int getAmount() {
        return map.size();
    }

}
