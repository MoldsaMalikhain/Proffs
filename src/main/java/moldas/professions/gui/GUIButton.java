package moldas.professions.gui;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUIButton {
    public ItemStack itemStack;
    private final String buttonName;

    /**
     * @param _itemStack Button img in GUI
     * @param _tittleColor Button tittle color in GUI
     * @param _buttonName Button tittle text in GUI
     * @param _buttonLore Button description in GUI
     */
    public GUIButton(Material _itemStack, ChatColor _tittleColor, String _buttonName, final String... _buttonLore) {
        itemStack = new ItemStack(_itemStack);
        ItemMeta buttonMeta = itemStack.getItemMeta();

        buttonName = _buttonName;
        buttonMeta.setDisplayName(_tittleColor + "" + _buttonName);
        buttonMeta.setLore(Arrays.asList(_buttonLore));
        itemStack.setItemMeta(buttonMeta);
    }

    /**
     * @param _itemStack Button img in GUI
     * @param _tittleColor Button tittle color in GUI
     * @param _buttonName Button tittle text in GUI
     */
    public GUIButton(Material _itemStack, ChatColor _tittleColor, String _buttonName) {
        itemStack = new ItemStack(_itemStack);
        ItemMeta buttonMeta = itemStack.getItemMeta();

        buttonName = _buttonName;
        buttonMeta.setDisplayName(_tittleColor + "" + _buttonName);
        itemStack.setItemMeta(buttonMeta);
    }

    public GUIButton setButtonLore(final String... _buttonLore) {
        ItemMeta buttonMeta = itemStack.getItemMeta();

        if(buttonMeta.getLore() == null) {
            buttonMeta.setLore(Arrays.asList(_buttonLore));
            itemStack.setItemMeta(buttonMeta);
            return this;
        }

        return this;
    }

    public String getButtonName() { return buttonName; }
}
