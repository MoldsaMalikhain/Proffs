package moldas.professions.prof.listners;

import moldas.professions.PlayerDataHandler;
import moldas.professions.prof.data.MinerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.UUID;

public class Miner implements Listener {

    PlayerDataHandler players;

    public Miner(PlayerDataHandler _players) {
        players = _players;
    }

    @EventHandler
    public void onBlockDestroyed(BlockBreakEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if(players.playerExist(playerUUID)
                && players.getPlayer(playerUUID).playerProfession.get("Primary").name.equals(MinerData.PROF_NAME)) {
            System.out.println("Block was mined");

            player.giveExp(25);
            player.sendMessage("You harvested" + event.getBlock());
        }
    }
}
