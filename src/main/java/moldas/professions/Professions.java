package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.prof.listners.Miner;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Professions extends JavaPlugin implements Listener {

    PlayerDataHandler playersData = new PlayerDataHandler();

    @Override
    public void onEnable() {

        //TODO Read players data from database

        this.getCommand("myproff").setExecutor(new MyProff());
        this.getCommand("getproff").setExecutor(new GetProff());
        this.getCommand("helpproff").setExecutor(new HelpProff());
        this.getCommand("listproff").setExecutor(new ListProff());
        this.getCommand("leaveproff").setExecutor(new LeaveProff());

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
    public void onLogin(PlayerLoginEvent event){
        Player player = event.getPlayer();
        if(playersData.addPlayer(player.getUniqueId(), player.getName())) {
            System.out.println(player.getName() + " entered to your server, a newbie here!");
            player.sendMessage("Welcome, " + player.getName() + ", please choose your professions using command...");
        }
        else {
            //TODO Changing players stats
            player.setMaxHealth(30);
        }
    }
}
