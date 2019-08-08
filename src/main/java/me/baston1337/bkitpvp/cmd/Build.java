package me.baston1337.bkitpvp.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.UUID;

public class Build implements CommandExecutor, Listener {

    private static ArrayList<UUID> build;

    public static ArrayList<UUID> getBuild() {
        return build;
    }

    public static void setBuild(ArrayList<UUID> build) {
        Build.build = build;
    }

    @EventHandler
    void onBlockBreakEvent(BlockBreakEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if(!getBuild().contains(uuid)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void onBlockPlaceEvent(BlockPlaceEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if(!getBuild().contains(uuid)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    void quit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        if(getBuild().contains(uuid)) {
            getBuild().remove(uuid);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNope"));
            return false;
        }

        return false;
    }
}
