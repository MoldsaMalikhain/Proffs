package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.prof.listners.Miner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class Professions extends JavaPlugin implements Listener {

    PlayerDataHandler playersData = new PlayerDataHandler();

    @Override
    public void onEnable() {

        //TODO Read players data from database

        this.getCommand("myprof").setExecutor(new MyProf());
        this.getCommand("getprof").setExecutor(new GetProf());
        this.getCommand("helpprof").setExecutor(new HelpProf());
        this.getCommand("listprof").setExecutor(new ListProf());
        this.getCommand("leaveprof").setExecutor(new LeaveProf());
        this.getCommand("changestat").setExecutor(new ChangeStat(playersData));
        this.getCommand("getstats").setExecutor(new GetStats(playersData));

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Miner(playersData), this);

        System.out.println("PLUGIN: prof-plugin is started");
        System.out.println("Profession plugin is Created by AT13, Moldas and ximure");
    }

    @Override
    public void onDisable() {
        //TODO Save players data to database
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
