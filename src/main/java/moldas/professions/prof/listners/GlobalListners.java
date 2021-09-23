package moldas.professions.prof.listners;

import moldas.professions.PlayerData;
import moldas.professions.PlayerDataHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class GlobalListners implements Listener {

    PlayerDataHandler playersData = new PlayerDataHandler();

    public GlobalListners(PlayerDataHandler _playerData) {
        playersData = _playerData;
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if(playersData.addPlayer(playerUUID, player.getName())) {
            System.out.println(player.getName() + " entered to your server, a newbie here!");
            player.sendMessage("Welcome, " + player.getName() + ", please choose your professions using command...");
        }

        //TODO Changing players stats
        //example of set logged in player stat from hash table
        //setting only stats that can be set by existing methods for object Player
        PlayerData currentPlayerStats = playersData.getPlayer(playerUUID);

        playersData.playerUpdate(playerUUID, currentPlayerStats);
    }
}
