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
            sender.sendMessage("Health: " + playerData.health);
            sender.sendMessage("Speed: " + playerData.speed);
            sender.sendMessage("Harvest speed: " + playerData.harvestSpeedMultiplier);
            sender.sendMessage("Jump height: " + playerData.jumpHeightMultiplier);
            sender.sendMessage("Falling damage reduce: " + playerData.fallingDamageMultiplier);
            sender.sendMessage("Damage: " + playerData.damageMultiplier);
            sender.sendMessage("Armor: " + playerData.armorMultiplier);
            sender.sendMessage("Shift speed: " + playerData.shiftSpeedMultiplier);
        }

        return false;
    }
}
