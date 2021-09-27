package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ChangeStat implements CommandExecutor {

    PlayerDataHandler players;

    public ChangeStat(PlayerDataHandler _players) {
        players = _players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {

            //Check if command entered correct
            if(args.length != 3){
                sender.sendMessage("Please enter command correct: /changestat <player_nickname> <stat> <amount>");
                return false;
            }

            String playerName = args[0];
            String statName = args[1];
            String statValue = args[2];

            //Check whether the entered value is a number
            try {
                Float.valueOf(statValue);
            } catch (NumberFormatException e) {
                sender.sendMessage("Entered wrong values!");
            }

            UUID playerUUID;
            PlayerData player;

            try {
                playerUUID = Bukkit.getServer().getPlayer(playerName).getUniqueId();
                player = players.getPlayer(playerUUID);
            } catch (NumberFormatException e) {
                sender.sendMessage("Cant find a player " + playerName);
                return false;
            } catch (NullPointerException e) {
                sender.sendMessage("Cant find a player " + playerName);
                return false;
            }

            switch(statName) {
                case "health":
                    player.health = Integer.parseInt(statValue);
                    break;
                case "speed":
                    player.speed = Float.parseFloat(statValue);
                    break;
                case "harvestSpeed":
                    player.harvestSpeedMultiplier = Float.parseFloat(statValue);
                    break;
                case "jumpHeight":
                    player.jumpHeightMultiplier = Float.parseFloat(statValue);
                    break;
                case "fallingDamage":
                    player.fallingDamageMultiplier = Float.parseFloat(statValue);
                    break;
                case "damage":
                    player.damageMultiplier = Float.parseFloat(statValue);
                    break;
                case "armor":
                    player.armorMultiplier = Float.parseFloat(statValue);
                    break;
                case "shiftSpeed":
                    player.shiftSpeedMultiplier = Float.parseFloat(statValue);
                    break;
                default:
                    sender.sendMessage("Entered wrong argument!");
                    break;
            }

            sender.sendMessage(player.speed + " " + player.health + " " + player.armorMultiplier);

            //Saving players updated stat
            players.playerUpdate(playerUUID, player);

            return true;
        }

        return false;
    }
}
