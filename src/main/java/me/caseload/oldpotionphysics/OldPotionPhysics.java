package me.caseload.oldpotionphysics;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import me.caseload.oldpotionphysics.command.MainCommand;
import me.caseload.oldpotionphysics.listener.ProjectileLaunchListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class OldPotionPhysics extends JavaPlugin implements Listener {

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        CommandAPI.onEnable();
        new MainCommand().register();

        getServer().getPluginManager().registerEvents(new ProjectileLaunchListener(), this);
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();
    }

    public static OldPotionPhysics getInstance() {
        return getPlugin(OldPotionPhysics.class);
    }
}
