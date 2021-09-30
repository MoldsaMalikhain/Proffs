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

public class LeaveProf implements CommandExecutor {

    Inventory professionLeaveGUI;
    PlayerDataHandler players;

    public LeaveProf(Inventory _professionLeaveGUI, PlayerDataHandler _players) {
        professionLeaveGUI = _professionLeaveGUI;
        players = _players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID playerUUID = player.getUniqueId();
            PlayerData playerData = players.getPlayer(playerUUID);

            //Open GUI
            GUIButton[] check = {
                    GUIButtons.MINER_BUTTON, GUIButtons.LUMBERJACK_BUTTON,
                    GUIButtons.FARMER_BUTTON, GUIButtons.ARCHER_BUTTON,
                    GUIButtons.WARRIOR_BUTTON, GUIButtons.BLACKSMITH_BUTTON,
                    GUIButtons.ALCHEMIST_BUTTON, GUIButtons.ENCHANTER_BUTTON
            };

            ItemStack[] items = new ItemStack[2];
            items[0] = GUIButtons.PRIMARY_PROF_NOT_DEFINED.itemStack;
            items[1] = GUIButtons.SECONDARY_PROF_NOT_DEFINED.itemStack;



            for(int i = 0; i < check.length; i++) {
                if(playerData.playerProfession.get("Primary") != null &&
                        playerData.playerProfession.get("Primary").equals(check[i].getButtonName())) {
                    items[0] = check[i].itemStack;
                    continue;
                }
                if(playerData.playerProfession.get("Secondary") != null &&
                        playerData.playerProfession.get("Secondary").equals(check[i].getButtonName())) {
                    items[1] = check[i].itemStack;
                    continue;
                }
            }

            MenuDataCreator menu = new MenuDataCreator(items[0], items[1], GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.CLOSE_BUTTON.itemStack);

            professionLeaveGUI.setContents(menu.getMenuItems());

            player.openInventory(professionLeaveGUI);

            return true;
        }

        return false;
    }
}
