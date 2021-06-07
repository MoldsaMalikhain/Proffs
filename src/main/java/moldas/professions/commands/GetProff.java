package moldas.professions.commands;

import moldas.professions.jsonhandler.JsonHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GetProff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            return false;
        }

        final String profession = "playerProfession";
        String[] defaultProfessions = {"miner", "lumberjack", "farmer"};

        Player player = (Player) sender;
        player.sendMessage("You typed : " + command.getName() + " " + args[0]);

        String[] data = {profession, args[0]};

        System.out.println("\n" + data[0] + "\n");

        for(String key : defaultProfessions){
            System.out.println(key);
            if(args[0].equals(key)){
                System.out.println("Time to rewrite");
                try {
                    new JsonHandler().write(data, player);
                    return true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("COMMAND 'GetProff' ERROR : please enter default profession from list : " + defaultProfessions);
                return false;
            }
        }

        return true;
    }
}