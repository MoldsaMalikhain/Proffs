package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyStats implements CommandExecutor {
    
    PlayerDataHandler players;
    
    public MyStats(PlayerDataHandler _players) {
        players = _players;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            //TODO Show stats of player in GUI
            PlayerData playerData = players.getPlayer(((Player) sender).getUniqueId());
            sender.sendMessage("Your stats is:");
            sender.sendMessage("Health: " + playerData.playerStats.health);
            sender.sendMessage("Speed: " + playerData.playerStats.speed);
            sender.sendMessage("Harvest speed: " + playerData.playerStats.harvestSpeedMultiplier);
            sender.sendMessage("Jump height: " + playerData.playerStats.jumpHeightMultiplier);
            sender.sendMessage("Falling damage reduce: " + playerData.playerStats.fallingDamageMultiplier);
            sender.sendMessage("Damage: " + playerData.playerStats.damageMultiplier);
            sender.sendMessage("Armor: " + playerData.playerStats.armorMultiplier);
            sender.sendMessage("Shift speed: " + playerData.playerStats.shiftSpeedMultiplier);
        }

        return false;
    }
}
