package moldas.professions;

import moldas.professions.database.PlayerDAO;
import moldas.professions.exceptions.SetPlayerException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Logger;

public class GlobalListeners implements Listener {
    PlayerDAO playerDAO;
    PlayerDataHandler playersData;

    private final Logger logger = Bukkit.getLogger();

    public GlobalListeners(PlayerDataHandler _playerData, PlayerDAO _playerDAO) {
        playersData = _playerData;
        playerDAO = _playerDAO;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        //TODO Read logged in player data? Maybe not needed here
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        try {
            if (playersData.addPlayer(playerUUID, player.getName())
                    && !playerDAO.exists(playerUUID)) {
                playerDAO.setPlayerData(playerUUID, playersData.getPlayer(playerUUID));

                System.out.println(ChatColor.YELLOW + "" + ChatColor.BOLD + "(*)" +
                        ChatColor.RESET + player.getName() + " entered to your server, a newbie here!");
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "(!)" +
                        ChatColor.RESET + " Welcome, " + player.getName() + ", please choose your professions using command /getprof");
            } else {
                playersData.addPlayer(playerUUID, player.getName());
                playersData.playerUpdate(playerUUID, playerDAO.getPlayerData(playerUUID));
            }
        } catch(SetPlayerException exception) {
            exception.printStackTrace();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        playerDAO.updatePlayerData(playerUUID, playersData.getPlayer(playerUUID));

        playersData.deletePlayer(playerUUID);
    }
}
