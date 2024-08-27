package me.caseload.oldpotionphysics.listener;

import me.caseload.oldpotionphysics.util.PhysicsHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunchListener implements Listener {

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player player) {
            event.getEntity().setVelocity(PhysicsHelper.getVelocity(player, player.getPitch(), player.getYaw(), -20.0F, 0.5F, 1.0F));
        }
    }
}
