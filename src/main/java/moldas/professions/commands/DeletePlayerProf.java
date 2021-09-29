package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.prof.data.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DeletePlayerProf implements CommandExecutor {

    PlayerDataHandler players;

    public DeletePlayerProf(PlayerDataHandler _players) {
        players = _players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {

            if(args.length != 2){
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Please enter command correct: /leaveprof <player_nickname> <profession>");
                return false;
            }

            String playerName = args[0];
            String profName = args[1];

            PlayerData playerData;
            UUID playerUUID;

            try {
                playerUUID = Bukkit.getServer().getPlayer(playerName).getUniqueId();
                playerData = players.getPlayer(playerUUID);
            } catch (NullPointerException e) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Cant find a player " + playerName);
                return false;
            }

            switch (profName) {
                case MinerData.PROF_NAME:
                    playerData.deleteProfession(MinerData.PROF_TYPE);
                    break;
                case LumberjackData.PROF_NAME:
                    playerData.deleteProfession(LumberjackData.PROF_TYPE);
                    break;
                case FarmerData.PROF_NAME:
                    playerData.deleteProfession(FarmerData.PROF_TYPE);
                    break;
                case BlacksmithData.PROF_NAME:
                    playerData.deleteProfession(BlacksmithData.PROF_TYPE);
                    break;
                case AlchemistData.PROF_NAME:
                    playerData.deleteProfession(AlchemistData.PROF_TYPE);
                    break;
                case ArcherData.PROF_NAME:
                    playerData.deleteProfession(ArcherData.PROF_TYPE);
                    break;
                case EnchanterData.PROF_NAME:
                    playerData.deleteProfession(EnchanterData.PROF_TYPE);
                    break;
                case WarriorData.PROF_NAME:
                    playerData.deleteProfession(WarriorData.PROF_TYPE);
                    break;
                default:
                    sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                            ChatColor.RESET + " Entered wrong argument!");
                    return true;
            }

            //Saving players updated stat
            players.playerUpdate(playerUUID, playerData);

            return true;
        }

        return false;
    }
}