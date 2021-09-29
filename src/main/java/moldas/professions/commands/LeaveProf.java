package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.MenuDataCreator;
import moldas.professions.prof.data.*;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Array;
import java.util.ArrayList;
import java.util.UUID;

public class LeaveProf implements CommandExecutor {

    PlayerDataHandler players;
    Inventory professionLeaveGUI;

    public LeaveProf (PlayerDataHandler _players, Inventory _professionLeaveGUI) {
        players = _players;
        professionLeaveGUI = _professionLeaveGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {

            if(args.length != 2 && args.length != 0){
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Please enter command correct: /leaveprof <player_nickname> <profession>");
                return false;
            }

            Player player = ((Player) sender).getPlayer();
            PlayerData playerData;

            //TODO GUI for choosing profession
            //Open GUI and ignore console command
            if(args.length == 0) {
                MenuDataCreator menu = new MenuDataCreator(
                        GUIButtons.MINER_BUTTON.itemStack, GUIButtons.LUMBERJACK_BUTTON.itemStack,
                        GUIButtons.FARMER_BUTTON.itemStack, GUIButtons.ARCHER_BUTTON.itemStack,
                        GUIButtons.WARRIOR_BUTTON.itemStack, GUIButtons.BLACKSMITH_BUTTON.itemStack,
                        GUIButtons.ALCHEMIST_BUTTON.itemStack, GUIButtons.ENCHANTER_BUTTON.itemStack,
                        GUIButtons.CLOSE_BUTTON.itemStack
                );
                professionLeaveGUI.setContents(menu.getMenuItems());

                player.openInventory(professionLeaveGUI);

                return true;
            }

            String playerName = args[0];
            String profName = args[1];

            UUID playerUUID;

            try {
                playerUUID = Bukkit.getServer().getPlayer(playerName).getUniqueId();
                playerData = players.getPlayer(playerUUID);
            } catch (NullPointerException e) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Cant find a player " + playerName);
                return false;
            }

            //For debug
            if(player.isOp()) {
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
            }

            //Saving players updated stat
            players.playerUpdate(playerUUID, playerData);

            return true;
        }

        return false;
    }
}