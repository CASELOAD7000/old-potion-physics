package me.caseload.oldpotionphysics.command;

import dev.jorel.commandapi.CommandAPICommand;
import me.caseload.oldpotionphysics.command.subcommand.ToggleSubcommand;
import org.bukkit.ChatColor;

public class MainCommand {

    @SuppressWarnings("deprecation")
    public void register() {
        new CommandAPICommand("oldpotionphysics")
                .withAliases("potionphysics", "opp")
                .withSubcommand(new ToggleSubcommand().getCommand())
                .executes((sender, args) -> {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6This server is running the &eOld Potion Physics &6Plugin. &bhttps://github.com/CASELOAD7000/old-potion-physics"));
                })
                .register();
    }
}
