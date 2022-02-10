package moldas.professions.gui.listeners;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.Professions;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.GUIConfirmationWindow;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;
import java.util.UUID;

public class GUIClickEvent implements Listener {

    PlayerDataHandler players;
    Inventory professionPickGUI;
    Inventory professionLeaveGUI;
    Inventory myProfessionGUI;
    Inventory myStatsGUI;

    String clickedProf = "";

    public GUIClickEvent(PlayerDataHandler _players, Inventory _professionPickGUI, Inventory _professionLeaveGUI,
                         Inventory _myProfessionGUI, Inventory _myStatsGUI) {
        players = _players;
        professionPickGUI = _professionPickGUI;
        professionLeaveGUI = _professionLeaveGUI;
        myProfessionGUI = _myProfessionGUI;
        myStatsGUI = _myStatsGUI;
    }

    //GUI EventHandler for /getprof command
    @EventHandler
    public void onClickPickProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (Objects.equals(e.getClickedInventory(), professionPickGUI)) {
                if(!checkClick(e)) return;

                String click = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());

                //GUI system buttons check
                if(click.equals(GUIButtons.CLOSE_BUTTON.getButtonName())) {
                    player.closeInventory();
                    return;
                }
                if(click.equals(GUIButtons.PRIMARY_PROF_NOT_DEFINED.getButtonName())
                        || click.equals(GUIButtons.SECONDARY_PROF_NOT_DEFINED.getButtonName())) {
                    player.chat("/getprof");
                    return;
                }

                playerData.setProfession(Professions.GUIMap.get(click), click);

                player.closeInventory();
            }
        } catch (NullPointerException exception) {
            return;
        }
    }

    //GUI EventHandler for /leaveprof command
    @EventHandler
    public void onClickLeaveProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        GUIConfirmationWindow confirmWindow = new GUIConfirmationWindow();

        try {
            if (e.getClickedInventory().equals(professionLeaveGUI)) {
                //Need to be right here, otherwise player can`t move items in his inventory
                if(!checkClick(e)) return;

                clickedProf = null;
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                //GUI system buttons check
                if(click.equals(GUIButtons.CLOSE_BUTTON.getButtonName())) {
                    player.closeInventory();
                    return;
                }
                if(click.equals(GUIButtons.PRIMARY_PROF_NOT_DEFINED.getButtonName())
                        || click.equals(GUIButtons.SECONDARY_PROF_NOT_DEFINED.getButtonName())) {
                    player.chat("/getprof");
                    return;
                }

                clickedProf = Professions.GUIMap.get(click);
                confirmWindow.open(player);
            }

            if(clickedProf != null && e.getClickedInventory().equals(GUIConfirmationWindow.confirmationWindowGUI)) {
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                //Need to be right here, otherwise player can`t move items in his inventory
                if(!checkClick(e)) return;

                if(confirmWindow.confirm(click)){
                    playerData.deleteProfession(clickedProf);
                }
                player.chat("/leaveprof");
            }
        } catch (NullPointerException exception) {
            return;
        }
    }

    //GUI EventHandler for /myprof command
    @EventHandler
    public void onClickMyProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (e.getClickedInventory().equals(myProfessionGUI)) {
                //Need to be right here, otherwise player can`t move items in his inventory
                if(!checkClick(e)) return;

                clickedProf = null;
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                //GUI system buttons check
                if(click.equals(GUIButtons.CLOSE_BUTTON.getButtonName())) {
                    player.closeInventory();
                    return;
                }
                if(click.equals(GUIButtons.PRIMARY_PROF_NOT_DEFINED.getButtonName())
                        || click.equals(GUIButtons.SECONDARY_PROF_NOT_DEFINED.getButtonName())) {
                    player.chat("/getprof");
                    return;
                }

                //Do mapping don`t be dumb
                //Open achievements of player professions
            }
        } catch(NullPointerException exception) {
            return;
        }
    }

    //GUI EventHandler for /mystats command
    @EventHandler
    public void onClickMyStats(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (e.getClickedInventory().equals(myStatsGUI)) {
                //Need to be right here, otherwise player can`t move items in his inventory
                if(!checkClick(e)) return;

                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                if(click.equals(GUIButtons.CLOSE_BUTTON.getButtonName())) {
                    player.closeInventory();
                    return;
                }

                //Do mapping, don`t be dumb
                //On Stats click
            }
        } catch(NullPointerException exception) {
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

    private boolean checkClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()
                || e.getCurrentItem().getItemMeta().equals(GUIButtons.NONE_BUTTON.itemStack.getItemMeta())){
            e.setCancelled(true);
            return false;
        }
        e.setCancelled(true);

        return true;
    }
}
