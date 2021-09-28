package moldas.professions.commands.tabcompleters;

import moldas.professions.prof.data.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GetProfTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {

        if(args.length == 2) {
            List<String> arguments = new ArrayList<>();

            //TODO Change to .yml file

            arguments.add(AlchemistData.PROF_NAME);
            arguments.add(ArcherData.PROF_NAME);
            arguments.add(BlacksmithData.PROF_NAME);
            arguments.add(EnchanterData.PROF_NAME);
            arguments.add(FarmerData.PROF_NAME);
            arguments.add(LumberjackData.PROF_NAME);
            arguments.add(MinerData.PROF_NAME);
            arguments.add(WarriorData.PROF_NAME);

            return arguments;
        }

        return null;
    }
}
