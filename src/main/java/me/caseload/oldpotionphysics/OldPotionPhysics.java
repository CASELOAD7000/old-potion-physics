package me.caseload.oldpotionphysics;

import me.caseload.oldpotionphysics.listener.ProjectileLaunchListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class OldPotionPhysics extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ProjectileLaunchListener(), this);
    }
}
