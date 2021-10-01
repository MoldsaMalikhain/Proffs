package moldas.professions.gui.listeners;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.data.GUIConfirmationWindow;
import moldas.professions.prof.data.*;
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

    String clickedProf = "";

    public GUIClickEvent(PlayerDataHandler _players, Inventory _professionPickGUI, Inventory _professionLeaveGUI, Inventory _myProfessionGUI) {
        players = _players;
        professionPickGUI = _professionPickGUI;
        professionLeaveGUI = _professionLeaveGUI;
        myProfessionGUI = _myProfessionGUI;
    }

    //GUI EventHandler for /getprof command
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
                        return;
                    case IRON_AXE:
                        playerData.setProfession(LumberjackData.PROF_TYPE, LumberjackData.PROF_NAME);
                        return;
                    case IRON_HOE:
                        playerData.setProfession(FarmerData.PROF_TYPE, FarmerData.PROF_NAME);
                        return;
                    case BOW:
                        playerData.setProfession(ArcherData.PROF_TYPE, ArcherData.PROF_NAME);
                        return;
                    case IRON_SWORD:
                        playerData.setProfession(WarriorData.PROF_TYPE, WarriorData.PROF_NAME);
                        return;
                    case ANVIL:
                        playerData.setProfession(BlacksmithData.PROF_TYPE, BlacksmithData.PROF_NAME);
                        return;
                    case BREWING_STAND:
                        playerData.setProfession(AlchemistData.PROF_TYPE, AlchemistData.PROF_NAME);
                        return;
                    case ENCHANTING_TABLE:
                        playerData.setProfession(EnchanterData.PROF_TYPE, EnchanterData.PROF_NAME);
                        return;
                    case BARRIER:
                        player.closeInventory();
                        return;
                }

                player.closeInventory();
                return;
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
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;
                e.setCancelled(true);

                clickedProf = null;
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                switch (click) {
                    case MinerData.PROF_NAME:
                        if(playerData.professionExist(MinerData.PROF_TYPE)) {
                            clickedProf = MinerData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case LumberjackData.PROF_NAME:
                        if(playerData.professionExist(LumberjackData.PROF_TYPE)) {
                            clickedProf = LumberjackData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case FarmerData.PROF_NAME:
                        if(playerData.professionExist(FarmerData.PROF_TYPE)) {
                            clickedProf = FarmerData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case ArcherData.PROF_NAME:
                        if(playerData.professionExist(ArcherData.PROF_TYPE)) {
                            clickedProf = ArcherData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        return;
                    case WarriorData.PROF_NAME:
                        if(playerData.professionExist(WarriorData.PROF_TYPE)) {
                            clickedProf = WarriorData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case BlacksmithData.PROF_NAME:
                        if(playerData.professionExist(BlacksmithData.PROF_TYPE)) {
                            clickedProf = BlacksmithData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case AlchemistData.PROF_NAME:
                        if(playerData.professionExist(AlchemistData.PROF_TYPE)) {
                            clickedProf = AlchemistData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case EnchanterData.PROF_NAME:
                        if(playerData.professionExist(EnchanterData.PROF_TYPE)) {
                            clickedProf = EnchanterData.PROF_TYPE;
                            confirmWindow.open(player);
                            break;
                        }
                        else return;
                    case "Close":
                        player.closeInventory();
                        return;
                    case "Primary":
                    case "Secondary":
                        player.chat("/getprof");
                        return;
                }
            }

            if(clickedProf != null && e.getClickedInventory().equals(GUIConfirmationWindow.confirmationWindowGUI)) {
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                //Need to be right here, otherwise player can`t move items in his inventory
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()
                        || e.getCurrentItem().getItemMeta().equals(GUIButtons.NONE_BUTTON.itemStack.getItemMeta())) {
                    e.setCancelled(true);
                    return;
                }
                e.setCancelled(true);

                if(confirmWindow.confirm(click)){
                    playerData.deleteProfession(clickedProf);
                }
                player.chat("/leaveprof");
            }

            return;
        } catch (NullPointerException exception) {
            return;
        }
    }

    @EventHandler
    public void onClickMyProfession(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        PlayerData playerData = players.getPlayer(playerUUID);

        try {
            if (e.getClickedInventory().equals(myProfessionGUI)) {
                //Need to be right here, otherwise player can`t move items in his inventory
                if (e.getCurrentItem() == null || e.getCurrentItem().getType().isAir()) return;
                e.setCancelled(true);

                clickedProf = null;
                String click = (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                switch (click) {
                    case MinerData.PROF_NAME:
                        if (playerData.professionExist(MinerData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case LumberjackData.PROF_NAME:
                        if (playerData.professionExist(LumberjackData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case FarmerData.PROF_NAME:
                        if (playerData.professionExist(FarmerData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case ArcherData.PROF_NAME:
                        if (playerData.professionExist(ArcherData.PROF_TYPE)) {
                            // ...
                            break;
                        }
                        return;
                    case WarriorData.PROF_NAME:
                        if (playerData.professionExist(WarriorData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case BlacksmithData.PROF_NAME:
                        if (playerData.professionExist(BlacksmithData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case AlchemistData.PROF_NAME:
                        if (playerData.professionExist(AlchemistData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case EnchanterData.PROF_NAME:
                        if (playerData.professionExist(EnchanterData.PROF_TYPE)) {
                            // ...
                            break;
                        } else return;
                    case "Close":
                        player.closeInventory();
                        return;
                    case "Primary":
                    case "Secondary":
                        player.chat("/getprof");
                        return;
                }
            }

            return;
        } catch(NullPointerException exeption) {
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
