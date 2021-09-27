package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.prof.data.FarmerData;
import moldas.professions.prof.data.LumberjackData;
import moldas.professions.prof.data.MinerData;
import moldas.professions.prof.listners.Lumberjack;
import moldas.professions.prof.listners.Miner;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GetProf implements CommandExecutor {

    PlayerDataHandler players;

    public GetProf(PlayerDataHandler _players) { players = _players; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {

            if(args.length != 2){
                sender.sendMessage("Please enter command correct: /getprof <player_nickname> <profession>");
                return false;
            }

            String playerName = args[0];
            String profName = args[1];

            UUID playerUUID;
            PlayerData player;

            try {
                playerUUID = Bukkit.getServer().getPlayer(playerName).getUniqueId();
                player = players.getPlayer(playerUUID);
            } catch (NullPointerException e) {
                sender.sendMessage("Cant find a player " + playerName);
                return false;
            }

            //TODO GUI for choosing profession

            //For debug
            switch(profName) {
                case "Miner":
                    player.setProfession(MinerData.PROF_TYPE, MinerData.PROF_NAME);
                    break;
                case "Lumberjack":
                    player.setProfession(LumberjackData.PROF_TYPE, LumberjackData.PROF_NAME);
                    break;
                case "Farmer":
                    player.setProfession(FarmerData.PROF_TYPE, FarmerData.PROF_NAME);
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

        //TODO add profession to player

        return true;
    }
}