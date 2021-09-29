package moldas.professions.commands.tabcompleters;

import moldas.professions.PlayerDataHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeletePlayerProfTabCompleter implements TabCompleter {

    PlayerDataHandler players;

    public DeletePlayerProfTabCompleter(PlayerDataHandler _players) {
        players = _players;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 2) {
            List<String> arguments = new ArrayList<>();
            UUID playerUUID = Bukkit.getPlayer(sender.getName()).getUniqueId();

            if(players.getPlayer(playerUUID).playerProfession.containsKey("Primary")) {
                arguments.add(players.getPlayer(playerUUID).playerProfession.get("Primary"));
            }
            if(players.getPlayer(playerUUID).playerProfession.containsKey("Secondary")) {
                arguments.add(players.getPlayer(playerUUID).playerProfession.get("Secondary"));
            }

            if(!arguments.isEmpty()) { return arguments; }
        }

        return null;
    }
}
