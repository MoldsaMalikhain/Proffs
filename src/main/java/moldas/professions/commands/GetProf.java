package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.data.ProfessionMenuData;
import moldas.professions.prof.data.*;
import moldas.professions.gui.GUIButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class GetProf implements CommandExecutor {

    PlayerDataHandler players;
    Inventory professionPickGUI;

    public GetProf(PlayerDataHandler _players, Inventory _professionPickGUI) {
        players = _players;
        professionPickGUI = _professionPickGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {

            if(args.length != 2 && args.length != 0){
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Please enter command correct: /getprof <player_nickname> <profession>");
                return false;
            }

            Player player = ((Player) sender).getPlayer();;

            if(args.length == 0) {
                professionPickGUI.setContents(ProfessionMenuData.menuItems);
                player.openInventory(professionPickGUI);

                return true;
            }

            String playerName = args[0];
            String profName = args[1];
            UUID playerUUID;
            PlayerData playerData;

            try {
                playerUUID = player.getUniqueId();
                playerData = players.getPlayer(playerUUID);
            } catch (NullPointerException e) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Cant find a player " + playerName);
                return false;
            }

            //For debug
            switch(profName) {
                case MinerData.PROF_NAME:
                    playerData.setProfession(MinerData.PROF_TYPE, MinerData.PROF_NAME);
                    break;
                case LumberjackData.PROF_NAME:
                    playerData.setProfession(LumberjackData.PROF_TYPE, LumberjackData.PROF_NAME);
                    break;
                case FarmerData.PROF_NAME:
                    playerData.setProfession(FarmerData.PROF_TYPE, FarmerData.PROF_NAME);
                    break;
                case BlacksmithData.PROF_NAME:
                    playerData.setProfession(BlacksmithData.PROF_TYPE, BlacksmithData.PROF_NAME);
                    break;
                case AlchemistData.PROF_NAME:
                    playerData.setProfession(AlchemistData.PROF_TYPE, AlchemistData.PROF_NAME);
                    break;
                case ArcherData.PROF_NAME:
                    playerData.setProfession(ArcherData.PROF_TYPE, ArcherData.PROF_NAME);
                    break;
                case EnchanterData.PROF_NAME:
                    playerData.setProfession(EnchanterData.PROF_TYPE, EnchanterData.PROF_NAME);
                    break;
                case WarriorData.PROF_NAME:
                    playerData.setProfession(WarriorData.PROF_TYPE, WarriorData.PROF_NAME);
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

        return true;
    }
}