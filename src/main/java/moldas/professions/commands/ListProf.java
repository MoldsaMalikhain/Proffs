package moldas.professions.commands;

import moldas.professions.prof.data.*;
import moldas.professions.prof.listners.Alchemist;
import moldas.professions.prof.listners.Miner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListProf implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(sender instanceof Player) {
            //TODO Show list of all profession in GUI
            sender.sendMessage("Professions: ");
            sender.sendMessage(AlchemistData.PROF_NAME);
            sender.sendMessage(ArcherData.PROF_NAME);
            sender.sendMessage(BlacksmithData.PROF_NAME);
            sender.sendMessage(EnchanterData.PROF_NAME);
            sender.sendMessage(FarmerData.PROF_NAME);
            sender.sendMessage(LumberjackData.PROF_NAME);
            sender.sendMessage(MinerData.PROF_NAME);
            sender.sendMessage(WarriorData.PROF_NAME);

            return true;
        }

        return false;
    }
}
