package xyz.thegamecube.meatcooker;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

/**
 * Listens for events regarding animal deaths.
 *
 * @author SirFaizdat
 * @since 1.0
 */
final class KillListener implements Listener {

    private MeatCooker plugin;

    KillListener(MeatCooker plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAnimalKilled(EntityDeathEvent e) {
        Entity victim = e.getEntity();
        if (victim.getLastDamageCause() instanceof EntityDamageByEntityEvent) {

            // This animal was killed, now let's check if a player killed it
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) victim.getLastDamageCause();
            if (damageEvent.getDamager() instanceof Player) {

                // A player killed it, let's get the player and drop the right item
                Player killer = (Player) damageEvent.getDamager();
                if (!killer.hasPermission("meatcooker.meat")) return; // Player doesn't have permission

                Material food = plugin.getMeatRegistry().getFood(victim.getType());
                if (food == null) return; // Animal doesn't have a food attached

                // Drop the meats!
                Material rawFood = plugin.getRawMeatRegistry().getFood(victim.getType());
                if (rawFood != null && getMaterialFromList(e.getDrops(), rawFood) >= 0)
                    e.getDrops().remove(getMaterialFromList(e.getDrops(), rawFood));
                e.getDrops().add(new ItemStack(food, randomAmount()));
            }
        }
    }

    private int getMaterialFromList(List<ItemStack> list, Material material) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getType() == material) return i;
        return -1;
    }

    private int randomAmount() {
        int rand = new Random().nextInt(10);
        if (rand < 7) return 1;
        else return 2;
    }

    @EventHandler
    public void onFishKilled(PlayerFishEvent e) {
        if (e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

            // The fish was caught, let's change it to our fish
            Item caughtFish = (Item) e.getCaught();

            Byte newFish = plugin.getFishRegistry().getFood(caughtFish.getItemStack().getData().getData());
            if (newFish == null) return; // Unregistered catch, ignore it

            ((Item) e.getCaught()).setItemStack(new ItemStack(Material.COOKED_FISH, 1, newFish));
        }
    }

}
