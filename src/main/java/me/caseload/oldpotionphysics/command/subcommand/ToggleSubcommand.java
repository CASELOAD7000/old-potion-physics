package me.caseload.oldpotionphysics.command.subcommand;

import dev.jorel.commandapi.CommandAPICommand;
import me.caseload.oldpotionphysics.OldPotionPhysics;
import org.bukkit.ChatColor;

public class ToggleSubcommand {

    @SuppressWarnings("deprecation")
    public CommandAPICommand getCommand() {
        return new CommandAPICommand("toggle")
                .withPermission("oldpotionphysics.toggle")
                .executes((sender, args) -> {
                    boolean toggledState = !OldPotionPhysics.getInstance().getConfig().getBoolean("enabled");

                    OldPotionPhysics.getInstance().getConfig().set("enabled", toggledState);
                    OldPotionPhysics.getInstance().saveConfig();

                    String message = ChatColor.translateAlternateColorCodes('&',
                            toggledState ?
                                    OldPotionPhysics.getInstance().getConfig().getString("enable_message", "&aSuccessfully enabled old potion physics.") :
                                    OldPotionPhysics.getInstance().getConfig().getString("disable_message", "&cSuccessfully disabled old potion physics.")
                    );

                    sender.sendMessage(message);
                });
    }
}
