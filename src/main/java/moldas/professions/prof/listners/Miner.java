package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.FileNotFoundException;

public class Miner implements Listener {

    PlayerDataHandler players;

    public Miner(PlayerDataHandler _players) {
        players = _players;
    }

    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) throws FileNotFoundException {

        Player player = event.getPlayer();

        System.out.println("Block was mined");

        player.giveExp(25);
        player.sendMessage("You harvested" + event.getBlock());
    }


    @EventHandler
    public void onLogin(PlayerLoginEvent event){

    }

    public void onLevelUp(){

    }


}
