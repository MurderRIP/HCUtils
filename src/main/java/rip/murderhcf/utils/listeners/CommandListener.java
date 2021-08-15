package rip.murderhcf.utils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import rip.murderhcf.utils.events.OPType;
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
        if (OPTypes.contains(event.getMessage().toLowerCase())) {
            String[] args = event.getMessage().split(" ");
            if (!event.isCancelled())
                Bukkit.getPluginManager().callEvent(new PlayerOppedEvent(Bukkit.getPlayer(args[1]), event.getPlayer(), OPType.OPPED));
        }

        if (DEOPTypes.contains(event.getMessage().toLowerCase())) {
            String[] args = event.getMessage().split(" ");
            if (!event.isCancelled())
                Bukkit.getPluginManager().callEvent(new PlayerOppedEvent(Bukkit.getPlayer(args[1]), event.getPlayer(), OPType.DEOPPED));
        }
    }
}
