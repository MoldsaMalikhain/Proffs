package moldas.professions.commands.guicommands;

import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.MenuDataCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class LeaveProf implements CommandExecutor {

    Inventory professionLeaveGUI;

    public LeaveProf(Inventory _professionLeaveGUI) {
        professionLeaveGUI = _professionLeaveGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            //Open GUI
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
        }

        return false;
    }
}
