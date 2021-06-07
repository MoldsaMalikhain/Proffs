package moldas.professions.prof;

import moldas.professions.jsonhandler.JsonHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.FileNotFoundException;

public class Miner implements Listener {


    public void setAsMiner(){

    }

    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) throws FileNotFoundException {

        Player player = event.getPlayer();
        String[] inputForRead = {"profession", "miner"};
        if(new JsonHandler().read(player, inputForRead)){

        }
    }


    @EventHandler
    public void onLogin(PlayerLoginEvent event){

    }

    public void onLevelUp(){

    }


}
