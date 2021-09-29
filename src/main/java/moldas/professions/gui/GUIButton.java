package moldas.professions.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUIButton {
    public ItemStack itemStack;

    public GUIButton(Material _itemStack, ChatColor tittleColor, String buttonName, final String... _buttonLore) {
        itemStack = new ItemStack(_itemStack);
        ItemMeta buttonMeta = itemStack.getItemMeta();

        buttonMeta.setDisplayName(tittleColor + "" + buttonName);
        buttonMeta.setLore(Arrays.asList(_buttonLore));
        itemStack.setItemMeta(buttonMeta);
    }
}
