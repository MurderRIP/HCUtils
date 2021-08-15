package rip.murderhcf.utils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import rip.murderhcf.utils.listeners.CommandListener;
import rip.murderhcf.utils.packets.SkinFixPacket;

@Getter
public class HCUtils extends JavaPlugin {

    @Getter
    private static HCUtils hcUtils;

    private SkinFixPacket skinFixPacket;

    @Override
    public void onEnable() {
        hcUtils = this;

        skinFixPacket = new SkinFixPacket(this);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    skinFixPacket.removeChanges(player);
                }
            }
        }.runTaskTimer(this, 60L, 60L);

        getServer().getPluginManager().registerEvents(new CommandListener(), this);
    }
}
