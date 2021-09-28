package moldas.professions.commands;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class MyProf implements CommandExecutor {

    PlayerDataHandler players;

    public MyProf(PlayerDataHandler _players) {
        players = _players;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            UUID playerUUID = player.getUniqueId();
            PlayerData playerData = players.getPlayer(playerUUID);

            //TODO Show list of player profession in GUI

            sender.sendMessage("Your professions: ");
            sender.sendMessage("Primary: " + playerData.playerProfession.get("Primary"));
            sender.sendMessage("Secondary: " + playerData.playerProfession.get("Secondary"));

            return true;
        }

        return false;
    }
}
