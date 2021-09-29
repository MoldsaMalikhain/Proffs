package moldas.professions.gui.listeners;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.prof.data.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;
import java.util.UUID;

public class ClickEvent implements Listener {

    PlayerDataHandler players;
    Inventory professionPickGUI;
    Inventory professionLeaveGUI;

    public ClickEvent(PlayerDataHandler _players, Inventory _professionPickGUI, Inventory _professionLeaveGUI) {
        players = _players;
        professionPickGUI = _professionPickGUI;
        professionLeaveGUI = _professionLeaveGUI;
    }

    @EventHandler
    public void onClickAddProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (Objects.equals(e.getClickedInventory(), professionPickGUI)) {
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
                        playerData.setProfession(WarriorData.PROF_TYPE, WarriorData.PROF_NAME);
                        break;
                    case ANVIL:
                        playerData.setProfession(BlacksmithData.PROF_TYPE, BlacksmithData.PROF_NAME);
                        break;
                    case BREWING_STAND:
                        playerData.setProfession(AlchemistData.PROF_TYPE, AlchemistData.PROF_NAME);
                        break;
                    case ENCHANTING_TABLE:
                        playerData.setProfession(EnchanterData.PROF_TYPE, EnchanterData.PROF_NAME);
                        break;
                    case BARRIER:
                        player.closeInventory();
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
    public void onClickLeaveProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (e.getClickedInventory().equals(professionLeaveGUI)) {
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;
                e.setCancelled(true);

                switch (e.getCurrentItem().getType()) {
                    case IRON_PICKAXE:
                        playerData.deleteProfession(MinerData.PROF_TYPE);
                        break;
                    case IRON_AXE:
                        playerData.deleteProfession(LumberjackData.PROF_TYPE);
                        break;
                    case IRON_HOE:
                        playerData.deleteProfession(FarmerData.PROF_TYPE);
                        break;
                    case BOW:
                        playerData.deleteProfession(ArcherData.PROF_TYPE);
                        break;
                    case IRON_SWORD:
                        playerData.deleteProfession(WarriorData.PROF_TYPE);
                        break;
                    case ANVIL:
                        playerData.deleteProfession(BlacksmithData.PROF_TYPE);
                        break;
                    case BREWING_STAND:
                        playerData.deleteProfession(AlchemistData.PROF_TYPE);
                        break;
                    case ENCHANTING_TABLE:
                        playerData.deleteProfession(EnchanterData.PROF_TYPE);
                        break;
                    case BARRIER:
                        player.closeInventory();
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
    public void onClickCancel(final InventoryDragEvent e) {
        try {
            if (e.getInventory().equals(professionPickGUI)) {
                e.setCancelled(true);
            }
        } catch (NullPointerException exception) {
            return;
        }
    }
}
