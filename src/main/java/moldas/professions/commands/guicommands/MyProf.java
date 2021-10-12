package moldas.professions.commands.guicommands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.GUIButton;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.MenuDataCreator;
import moldas.professions.prof.Profession;
import moldas.professions.progress.data.ProgressMaxValues;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MyProf implements CommandExecutor {

    PlayerDataHandler players;
    Inventory myProfessionGUI;

    public MyProf(PlayerDataHandler _players, Inventory _myProfessionGUI) {
        players = _players;
        myProfessionGUI = _myProfessionGUI;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID playerUUID = player.getUniqueId();
            PlayerData playerData = players.getPlayer(playerUUID);

            //Open GUI
            List<GUIButton> check =  new ArrayList<>();
                check.add(GUIButtons.MINER_BUTTON_CUSTOM);
                check.add(GUIButtons.LUMBERJACK_BUTTON_CUSTOM);
                check.add(GUIButtons.FARMER_BUTTON_CUSTOM);
                check.add(GUIButtons.ARCHER_BUTTON_CUSTOM);
                check.add(GUIButtons.WARRIOR_BUTTON_CUSTOM);
                check.add(GUIButtons.BLACKSMITH_BUTTON_CUSTOM);
                check.add(GUIButtons.ALCHEMIST_BUTTON_CUSTOM);
                check.add(GUIButtons.ENCHANTER_BUTTON_CUSTOM);

            ItemStack[] items = new ItemStack[2];
            items[0] = GUIButtons.PRIMARY_PROF_NOT_DEFINED.itemStack;
            items[1] = GUIButtons.SECONDARY_PROF_NOT_DEFINED.itemStack;

            //TODO: On button click open achievements for player profs
            if(playerData.playerProfession.get("Primary") != null) {
                Profession profession = playerData.playerProfession.get("Primary");
                items[0] = check.stream()
                        .filter(x -> profession.name.equals(x.getButtonName()))
                        .findAny()
                        .get()
                        .setButtonLore(
                                "Profession level: "
                                        + profession.lvl + "/"
                                        + ProgressMaxValues.MAX_LVL,
                                ChatColor.YELLOW + "Your progress on this profession: "
                                        + profession.progress + "/"
                                        + ProgressMaxValues.POINTS_TO_LVL_UP
                        ).itemStack;
            }

            if(playerData.playerProfession.get("Secondary") != null) {
                Profession profession = playerData.playerProfession.get("Secondary");
                items[1] = check.stream()
                        .filter(x -> profession.name.equals(x.getButtonName()))
                        .findAny()
                        .get()
                        .setButtonLore(
                                "Profession level: "
                                        + profession.lvl + "/"
                                        + ProgressMaxValues.MAX_LVL,
                                ChatColor.YELLOW + "Your progress on this profession: "
                                        + profession.progress + "/"
                                        + ProgressMaxValues.POINTS_TO_LVL_UP
                        ).itemStack;
            }

            HashMap<Integer, ItemStack> buttons = new HashMap<>();
            buttons.put(12, items[0]);
            buttons.put(16, items[1]);

            MenuDataCreator menu = new MenuDataCreator(buttons, myProfessionGUI.getSize());
            myProfessionGUI.setContents(menu.getMenuItems());
            player.openInventory(myProfessionGUI);

            return true;
        }

        return false;
    }
}
