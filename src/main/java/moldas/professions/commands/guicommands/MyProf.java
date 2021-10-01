package moldas.professions.commands.guicommands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.GUIButton;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.MenuDataCreator;
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

            //TODO Show list of player profession in GUI

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

            for(int i = 0; i < check.length; i++) {
                if(playerData.playerProfession.get("Primary") != null &&
                        playerData.playerProfession.get("Primary").equals(check[i].getButtonName())) {
                    check[i].setButtonLore("Your profession level: "
                                    + players.getPlayer(playerUUID).playerProfessionProgress.primaryProfLvl,
                            "Your progress on this profession "
                                    + players.getPlayer(playerUUID).playerProfessionProgress.primaryProfProgress);
                    items[0] = check[i].itemStack;
                    continue;
                }
                if(playerData.playerProfession.get("Secondary") != null &&
                        playerData.playerProfession.get("Secondary").equals(check[i].getButtonName())) {
                    check[i].setButtonLore("Your profession level: "
                                    + players.getPlayer(playerUUID).playerProfessionProgress.secondaryProfLvl,
                            "Your progress on this profession: "
                                    + players.getPlayer(playerUUID).playerProfessionProgress.secondaryProfProgress);
                    items[1] = check[i].itemStack;
                    continue;
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
