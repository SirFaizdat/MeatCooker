package xyz.thegamecube.meatcooker;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * The version command for the plugin.
 *
 * @author SirFaizdat
 * @since 1.0
 */
final class VersionCommand implements CommandExecutor {

    private MeatCooker plugin;

    VersionCommand(MeatCooker plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GREEN + plugin.getDescription().getFullName());
        sender.sendMessage(ChatColor.DARK_GREEN + "Crafted with <3 by SirFaizdat.");
        sender.sendMessage(ChatColor.DARK_GRAY + String.format("%d meat and %d fish are registered.", plugin.getMeatRegistry().getAmount(), plugin.getFishRegistry().getAmount()));
        return true;
    }

}
