package moldas.professions.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUIButton {
    public ItemStack itemStack;
    private final String buttonName;

    public GUIButton(Material _itemStack, ChatColor _tittleColor, String _buttonName, final String... _buttonLore) {
        itemStack = new ItemStack(_itemStack);
        ItemMeta buttonMeta = itemStack.getItemMeta();

        buttonName = _buttonName;
        buttonMeta.setDisplayName(_tittleColor + "" + _buttonName);
        buttonMeta.setLore(Arrays.asList(_buttonLore));
        itemStack.setItemMeta(buttonMeta);
    }

    public String getButtonName() { return buttonName; }
}
