package moldas.professions.commands.guicommands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import moldas.professions.gui.GUIButton;
import moldas.professions.gui.data.GUIButtons;
import moldas.professions.gui.MenuDataCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LeaveProf implements CommandExecutor {

    Inventory professionLeaveGUI;
    PlayerDataHandler players;

    public LeaveProf(Inventory _professionLeaveGUI, PlayerDataHandler _players) {
        professionLeaveGUI = _professionLeaveGUI;
        players = _players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID playerUUID = player.getUniqueId();
            PlayerData playerData = players.getPlayer(playerUUID);

            //Open GUI
            List<GUIButton> check = new ArrayList<>();
                check.add(GUIButtons.MINER_BUTTON);
                check.add(GUIButtons.LUMBERJACK_BUTTON);
                check.add(GUIButtons.FARMER_BUTTON);
                check.add(GUIButtons.ARCHER_BUTTON);
                check.add(GUIButtons.WARRIOR_BUTTON);
                check.add(GUIButtons.BLACKSMITH_BUTTON);
                check.add(GUIButtons.ALCHEMIST_BUTTON);
                check.add(GUIButtons.ENCHANTER_BUTTON);

            ItemStack[] items = new ItemStack[2];
            items[0] = GUIButtons.PRIMARY_PROF_NOT_DEFINED.itemStack;
            items[1] = GUIButtons.SECONDARY_PROF_NOT_DEFINED.itemStack;

            if(playerData.playerProfession.get("Primary") != null)
                items[0] = check.stream()
                        .filter(x -> playerData.playerProfession.get("Primary").name.equals(x.getButtonName()))
                        .findAny()
                        .get()
                        .itemStack;

            if(playerData.playerProfession.get("Secondary") != null)
                items[1] = check.stream()
                        .filter(x -> playerData.playerProfession.get("Secondary").name.equals(x.getButtonName()))
                        .findAny()
                        .get()
                        .itemStack;

            MenuDataCreator menu = new MenuDataCreator(items[0], items[1], GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack,
                    GUIButtons.NONE_BUTTON.itemStack, GUIButtons.NONE_BUTTON.itemStack, GUIButtons.CLOSE_BUTTON.itemStack);

            professionLeaveGUI.setContents(menu.getMenuItems());

            player.openInventory(professionLeaveGUI);

            return true;
        }

        return false;
    }
}
