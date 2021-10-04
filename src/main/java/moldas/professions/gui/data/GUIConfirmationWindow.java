package moldas.professions.gui.data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUIConfirmationWindow {

    public static final Inventory confirmationWindowGUI = Bukkit.createInventory(null, 9, ChatColor.RED + "Are you sure?");

    MenuDataCreator menu = new MenuDataCreator(
            GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
            GUIButtons.YES_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
            GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
            GUIButtons.NO_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
            GUIButtons.NONE_BUTTON.itemStack
    );

    public GUIConfirmationWindow() {
        confirmationWindowGUI.setContents(menu.getMenuItems());
    }

    /**
     * @param player Player that need to confirm his action
     */
    public void open(Player player) {
        player.openInventory(confirmationWindowGUI);
    }

    /**
     * @param click Button which pressed, compare with GUIButton.YES_BUTTON
     * @return true if click was on GUIButton.YES_BUTTON
     * false if was clicked any other button
     */
    public boolean confirm(String click) {

        if(click != null && click.equals(ChatColor.stripColor(GUIButtons.YES_BUTTON.itemStack.getItemMeta().getDisplayName()))) return true;

        return false;
    }
}
