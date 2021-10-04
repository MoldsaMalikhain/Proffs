package moldas.professions.gui;

import org.bukkit.inventory.ItemStack;

/**
 * Class for flexible menu creating
 * Items adding using constructor
 */
public class MenuDataCreator {

    private ItemStack[] menuItems;

    public MenuDataCreator(ItemStack... items) {
        menuItems = items;
    }

    public ItemStack[] getMenuItems() {
        return menuItems;
    }
}
