package xyz.thegamecube.meatcooker;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps the animal type to the meat type.
 *
 * @author SirFaizdat
 * @since 1.0
 */
final class MeatRegistry {

    private Map<EntityType, Material> map;

    void init() {
        this.map = new HashMap<>();

        this.map.put(EntityType.COW, Material.COOKED_BEEF);
        this.map.put(EntityType.CHICKEN, Material.COOKED_CHICKEN);
        this.map.put(EntityType.SHEEP, Material.COOKED_MUTTON);
        this.map.put(EntityType.RABBIT, Material.COOKED_RABBIT);
        this.map.put(EntityType.PIG, Material.GRILLED_PORK);
    }

    Material getFood(EntityType animal) {
        return map.get(animal);
    }

    int getAmount() {
        return map.size();
    }

}
