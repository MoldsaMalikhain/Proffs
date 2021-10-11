package moldas.professions.commands.guicommands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.GUIButton;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.MenuDataCreator;
import moldas.professions.prof.Profession;
import moldas.professions.progress.data.ProgressMaxValues;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class MyProf implements CommandExecutor {

    PlayerDataHandler players;
    Inventory myProfessionGUI;

    public MyProf(PlayerDataHandler _players, Inventory _myProfessionGUI) {
        players = _players;
        myProfessionGUI = _myProfessionGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID playerUUID = player.getUniqueId();
            PlayerData playerData = players.getPlayer(playerUUID);

            //Open GUI
            GUIButton[] check = {
                    GUIButtons.MINER_BUTTON_CUSTOM, GUIButtons.LUMBERJACK_BUTTON_CUSTOM,
                    GUIButtons.FARMER_BUTTON_CUSTOM, GUIButtons.ARCHER_BUTTON_CUSTOM,
                    GUIButtons.WARRIOR_BUTTON_CUSTOM, GUIButtons.BLACKSMITH_BUTTON_CUSTOM,
                    GUIButtons.ALCHEMIST_BUTTON_CUSTOM, GUIButtons.ENCHANTER_BUTTON_CUSTOM
            };

            ItemStack[] items = new ItemStack[2];
            items[0] = GUIButtons.PRIMARY_PROF_NOT_DEFINED.itemStack;
            items[1] = GUIButtons.SECONDARY_PROF_NOT_DEFINED.itemStack;

            //TODO: On button click open achievements for player profs
            //Custom buttons construction with player data information
            if(playerData.playerProfession.get("Primary") != null) {

                Profession profession = playerData.playerProfession.get("Primary");

                for(int i = 0; i < check.length; i++) {
                    if(profession.name.equals(check[i].getButtonName())) {
                        check[i].setButtonLore("Profession level: "
                                        + profession.lvl + "/"
                                        + ProgressMaxValues.MAX_LVL,
                                ChatColor.YELLOW + "Your progress on this profession: "
                                        + profession.progress + "/"
                                        + ProgressMaxValues.POINTS_TO_LVL_UP);
                        items[0] = check[i].itemStack;

                        break;
                    }
                }
            }

            if(playerData.playerProfession.get("Secondary") != null) {
                Profession profession = playerData.playerProfession.get("Secondary");

                for(int i = 0; i < check.length; i++) {
                    if(profession.name.equals(check[i].getButtonName())) {
                        check[i].setButtonLore("Profession level: "
                                        + profession.lvl + "/"
                                        + ProgressMaxValues.MAX_LVL,
                                ChatColor.YELLOW + "Your progress on this profession: "
                                        + profession.progress + "/"
                                        + ProgressMaxValues.POINTS_TO_LVL_UP);
                        items[1] = check[i].itemStack;
                        break;
                    }
                }
            }

            MenuDataCreator menu = new MenuDataCreator(
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, items[0],
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    items[1], GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack);

            myProfessionGUI.setContents(menu.getMenuItems());
            player.openInventory(myProfessionGUI);

            return true;
        }

        return false;
    }
}
