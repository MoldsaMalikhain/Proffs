package moldas.professions.gui;

import moldas.professions.gui.data.GUIButtons;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Set;

/**
 * Class for flexible menu creating
 * Items adding using constructor
 */
public class MenuDataCreator {

    private ItemStack[] menuItems;

    public MenuDataCreator(ItemStack... items) {
        menuItems = items;
    }

    /**
     * Autofill the empty inventory cells with GUIButton.NONE_BUTTON
     * Add buttons map into the GUI
     * @param items Button map with key that represent position in inventory GUI
     * @param menuSize size of GUI inventory
     */
    public MenuDataCreator(HashMap<Integer, ItemStack> items, int menuSize) {
        Set<Integer> keys = items.keySet();
        menuItems = new ItemStack[menuSize];

        //Fill the GUI with GUIButton.NONE_BUTTON
        for(int i = 0; i < menuSize; i++) {
            menuItems[i] = GUIButtons.NONE_BUTTON.itemStack;
        }

        //Set the buttons where it needed to be
        for (int key : keys) {
            menuItems[key - 1] = items.get(key);
        }
    }

    public ItemStack[] getMenuItems() {
        return menuItems;
    }
}
