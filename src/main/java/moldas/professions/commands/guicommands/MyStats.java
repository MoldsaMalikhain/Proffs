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
            Player player = ((Player) sender).getPlayer();
            PlayerData playerData = players.getPlayer(player.getUniqueId());

            //Open GUI
            //Custom buttons construction with player stats information
            GUIButton athletic = GUIButtons.ATHLETIC_BUTTON_CUSTOM;
            athletic.setButtonLore("Current level: "
                            + playerData.playerStats.athletic.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.athletic.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.athletic.getLvl());
            GUIButton acrobatic = GUIButtons.ACROBATIC_BUTTONS_CUSTOM;
            acrobatic.setButtonLore("Current level: "
                            + playerData.playerStats.acrobatic.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.acrobatic.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.acrobatic.getLvl());
            GUIButton strength = GUIButtons.STRENGTH_BUTTON_CUSTOM;
            strength.setButtonLore("Current level: "
                            + playerData.playerStats.strength.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.strength.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.strength.getLvl());
            GUIButton blocking = GUIButtons.BLOCKING_BUTTON_CUSTOM;
            blocking.setButtonLore("Current level: "
                            + playerData.playerStats.blocking.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.blocking.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.blocking.getLvl());
            GUIButton vitality = GUIButtons.VITALITY_BUTTON_CUSTOM;
            vitality.setButtonLore("Current level: "
                            + playerData.playerStats.vitality.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.vitality.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.vitality.getLvl());
            GUIButton stealth = GUIButtons.STEALTH_BUTTON_CUSTOM;
            stealth.setButtonLore("Current level: "
                            + playerData.playerStats.stealth.getLvl() + "/" + ProgressMaxValues.MAX_LVL,
                    ChatColor.YELLOW + "Next level: "
                            + playerData.playerStats.stealth.getProgress() + "/"
                            + ProgressMaxValues.POINTS_TO_LVL_UP * playerData.playerStats.stealth.getLvl());

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
