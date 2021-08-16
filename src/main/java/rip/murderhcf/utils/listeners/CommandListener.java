package rip.murderhcf.utils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import rip.murderhcf.utils.events.PlayerDeoppedEvent;
import rip.murderhcf.utils.events.PlayerOppedEvent;

import java.util.Arrays;
import java.util.List;

public class CommandListener implements Listener {

    static List<String> OPTypes =
            Arrays.asList(
                    "/op",
                    "/bukkit:op",
                    "/minecraft:op"
            );

    static List<String> DEOPTypes =
            Arrays.asList(
                    "/deop",
                    "/bukkit:deop",
                    "/minecraft:deop"
            );

    @EventHandler
    public void onOPCommand(PlayerCommandPreprocessEvent event) {
        String[] args = event.getMessage().split(" ");
        if (args.length >= 1) {
            if (OPTypes.stream().anyMatch(s -> event.getMessage().contains(s)) && !event.isCancelled())
                Bukkit.getPluginManager().callEvent(new PlayerOppedEvent(Bukkit.getOfflinePlayer(args[1]), event.getPlayer()));

            if (DEOPTypes.stream().anyMatch(s -> event.getMessage().contains(s)) && !event.isCancelled())
                Bukkit.getPluginManager().callEvent(new PlayerDeoppedEvent(Bukkit.getOfflinePlayer(args[1]), event.getPlayer()));
        }
    }
}
