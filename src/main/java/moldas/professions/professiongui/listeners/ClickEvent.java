package moldas.professions.professiongui.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        try {
            if (e.getClickedInventory().toString() != ChatColor.GOLD + "Profession choice") {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;
                e.setCancelled(true);

                //TODO do stuff

                return;
            }
        } catch (NullPointerException exception) {
            return;
        }
    }

    @EventHandler
    public void onClick(final InventoryDragEvent e) {
        try {
            if (e.getInventory().toString() != ChatColor.GOLD + "Profession choice") {
                e.setCancelled(true);
            }
        } catch (NullPointerException exception) {
            return;
        }
    }
}
