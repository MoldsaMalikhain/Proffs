package moldas.professions.commands;

import moldas.professions.gui.MenuDataCreator;
import moldas.professions.gui.data.GUIButtons;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class HelpProf implements CommandExecutor {

    private final Inventory pluginInfoGUI;

    public HelpProf(Inventory _pluginInfoGUI) {
        pluginInfoGUI = _pluginInfoGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            ItemStack[] items = new ItemStack[3];
            items[0] = GUIButtons.AT13_HEAD.itemStack;
            items[1] = GUIButtons.XIMURE_HEAD.itemStack;
            items[2] = GUIButtons.MOLDAS_HEAD.itemStack;

            HashMap<Integer, ItemStack> buttons = new HashMap<>();
            buttons.put(12, items[0]);
            buttons.put(14, items[1]);
            buttons.put(16, items[2]);

            MenuDataCreator menu = new MenuDataCreator(buttons, pluginInfoGUI.getSize());
            pluginInfoGUI.setContents(menu.getMenuItems());
            player.openInventory(pluginInfoGUI);

            return true;
        }
        //TODO
        // show information about professions and
        // plugin
        // in GUI

        return false;
    }
}