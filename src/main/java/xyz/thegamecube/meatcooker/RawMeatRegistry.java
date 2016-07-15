package xyz.thegamecube.meatcooker;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SirFaizdat
 */
public class RawMeatRegistry {

    private Map<EntityType, Material> map;

    void init() {
        this.map = new HashMap<>();

        this.map.put(EntityType.COW, Material.RAW_BEEF);
        this.map.put(EntityType.CHICKEN, Material.RAW_CHICKEN);
        this.map.put(EntityType.SHEEP, Material.MUTTON);
        this.map.put(EntityType.RABBIT, Material.RABBIT);
        this.map.put(EntityType.PIG, Material.PORK);
    }

    Material getFood(EntityType animal) {
        return map.get(animal);
    }

    int getAmount() {
        return map.size();
    }

}
