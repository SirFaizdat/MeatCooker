package xyz.thegamecube.meatcooker;

import org.bukkit.plugin.java.JavaPlugin;

public final class MeatCooker extends JavaPlugin {

    private MeatRegistry meatRegistry;
    private RawMeatRegistry rawMeatRegistry;
    private FishRegistry fishRegistry;

    @Override
    public void onEnable() {
        this.meatRegistry = new MeatRegistry();
        this.rawMeatRegistry = new RawMeatRegistry();
        this.fishRegistry = new FishRegistry();

        this.meatRegistry.init();
        this.rawMeatRegistry.init();
        this.fishRegistry.init();

        this.getServer().getPluginManager().registerEvents(new KillListener(this), this);
        this.getCommand("meatcooker").setExecutor(new VersionCommand(this));

        getLogger().info("Enabled " + getDescription().getFullName() + ". Crafted with <3 by SirFaizdat.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled " + getDescription().getFullName() + ". I'm sure you'll miss me!");
    }

    MeatRegistry getMeatRegistry() {
        return meatRegistry;
    }

    RawMeatRegistry getRawMeatRegistry() {
        return rawMeatRegistry;
    }

    FishRegistry getFishRegistry() {
        return fishRegistry;
    }

}
