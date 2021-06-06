package moldas.professions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetProff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;
        player.sendMessage("You typed : " + command.getName() + " " + args[0]);



        return true;
    }
}