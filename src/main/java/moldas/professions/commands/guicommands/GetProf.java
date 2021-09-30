package moldas.professions.commands.guicommands;

import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.MenuDataCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GetProf implements CommandExecutor {

    Inventory professionPickGUI;

    public GetProf(Inventory _professionPickGUI) {
        professionPickGUI = _professionPickGUI;
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
                professionPickGUI.setContents(menu.getMenuItems());
                player.openInventory(professionPickGUI);

                return true;
            }
        }

        return false;
    }
}
