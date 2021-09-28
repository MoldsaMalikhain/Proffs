package moldas.professions.professiongui.listeners;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.prof.data.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.UUID;

public class ClickEvent implements Listener {

    PlayerDataHandler players;

    public ClickEvent(PlayerDataHandler _players) {
        players = _players;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (e.getClickedInventory().toString() != ChatColor.GOLD + "Profession choice") {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {
                    case IRON_PICKAXE:
                        playerData.setProfession(MinerData.PROF_TYPE, MinerData.PROF_NAME);
                        break;
                    case IRON_AXE:
                        playerData.setProfession(LumberjackData.PROF_TYPE, LumberjackData.PROF_NAME);
                        break;
                    case IRON_HOE:
                        playerData.setProfession(FarmerData.PROF_TYPE, FarmerData.PROF_NAME);
                        break;
                    case BOW:
                        playerData.setProfession(ArcherData.PROF_TYPE, ArcherData.PROF_NAME);
                        break;
                    case IRON_SWORD:
                        playerData.setProfession(AlchemistData.PROF_TYPE, AlchemistData.PROF_NAME);
                        break;
                    case ANVIL:
                        playerData.setProfession(BlacksmithData.PROF_TYPE, BlacksmithData.PROF_NAME);
                        break;
                    case BREWING_STAND:
                        playerData.setProfession(EnchanterData.PROF_TYPE, EnchanterData.PROF_NAME);
                        break;
                    case ENCHANTING_TABLE:
                        playerData.setProfession(WarriorData.PROF_TYPE, WarriorData.PROF_NAME);
                        break;
                }

                player.closeInventory();
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
