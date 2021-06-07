package moldas.professions.prof;

import moldas.professions.jsonhandler.JsonHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.FileNotFoundException;

public class Miner implements Listener {

    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) throws FileNotFoundException {

        Player player = event.getPlayer();
        String[] inputForRead = {"playerProfession", "miner"};
        if(new JsonHandler().read(player, inputForRead)){
            System.out.println("Block was mined");
        }
    }


    @EventHandler
    public void onLogin(PlayerLoginEvent event){

    }

    public void onLevelUp(){

    }


}
