package rip.murderhcf.utils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
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
                Bukkit.getOnlinePlayers().forEach(skinFixPacket::removeChanges);
            }
        }.runTaskTimerAsynchronously(this, 60L, 60L);
    }
}
