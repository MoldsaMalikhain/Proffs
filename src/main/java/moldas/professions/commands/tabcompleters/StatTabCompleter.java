package moldas.professions.commands.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class StatTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 2) {
            List<String> arguments = new ArrayList<>();

            arguments.add("health");
            arguments.add("speed");
            arguments.add("harvestSpeed");
            arguments.add("jumpHeight");
            arguments.add("fallingDamage");
            arguments.add("damage");
            arguments.add("armor");
            arguments.add("shiftSpeed");

            return arguments;
        }

        return null;
    }
}
