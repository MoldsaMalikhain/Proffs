package moldas.professions.commands.guicommands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.GUIButton;
import moldas.professions.gui.MenuDataCreator;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.progress.data.ProgressMaxValues;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MyStats implements CommandExecutor {
    
    PlayerDataHandler players;
    Inventory myStatsGUI;
    
    public MyStats(PlayerDataHandler _players, Inventory _myStatsGUI) {
        players = _players;
        myStatsGUI = _myStatsGUI;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            //TODO Show stats of player in GUI
            Player player = ((Player) sender).getPlayer();
            PlayerData playerData = players.getPlayer(player.getUniqueId());

            //Open GUI
            //Custom buttons construction with player stats information
            GUIButton athletic = GUIButtons.ATHLETIC_BUTTON_CUSTOM;
            athletic.setButtonLore("Current level: "
                            + playerData.playerStats.athletic + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.athleticProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);
            GUIButton acrobatic = GUIButtons.ACROBATIC_BUTTONS_CUSTOM;
            acrobatic.setButtonLore("Current level: "
                            + playerData.playerStats.acrobatic + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.acrobaticProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);
            GUIButton strength = GUIButtons.STRENGTH_BUTTON_CUSTOM;
            strength.setButtonLore("Current level: "
                            + playerData.playerStats.strength + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.strengthProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);
            GUIButton blocking = GUIButtons.BLOCKING_BUTTON_CUSTOM;
            blocking.setButtonLore("Current level: "
                            + playerData.playerStats.blocking + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.blockingProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);
            GUIButton vitality = GUIButtons.VITALITY_BUTTON_CUSTOM;
            vitality.setButtonLore("Current level: "
                            + playerData.playerStats.vitality + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.vitalityProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);
            GUIButton stealth = GUIButtons.STEALTH_BUTTON_CUSTOM;
            stealth.setButtonLore("Current level: "
                            + playerData.playerStats.stealth + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStatsProgress.stealthProgress + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP);

            MenuDataCreator menu = new MenuDataCreator(
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, athletic.itemStack, acrobatic.itemStack,
                    strength.itemStack, blocking.itemStack, vitality.itemStack,
                    stealth.itemStack, GUIButtons.CLOSE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack
            );

            myStatsGUI.setContents(menu.getMenuItems());
            player.openInventory(myStatsGUI);

            return true;
        }

        return false;
    }
}
