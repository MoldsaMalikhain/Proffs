package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.prof.Miner;
import moldas.professions.jsonhandler.JsonHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Professions extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {

//        this.getCommand("myproff").setExecutor(new MyProff());
        this.getCommand("getproff").setExecutor(new GetProff());
//        this.getCommand("helpproff").setExecutor(new HelpProff());
//        this.getCommand("listproff").setExecutor(new ListProff());
//        this.getCommand("leaveproff").setExecutor(new LeaveProff());

        System.out.println("PLUGIN: prof-plugin is started");
        System.out.println("Profession plugin is Created by Moldas");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new Miner(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

//    @EventHandler
//    public void onMine(BlockBreakEvent event){
//        System.out.print("Mined");
//        Player player = event.getPlayer();
//        player.giveExp(25);
//        player.sendMessage("You harvested" + event.getBlock());
//    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        System.out.println("Someone entered to your server");
        JsonHandler handler = new JsonHandler();
        Player player = event.getPlayer();
        try{
            handler.createCatalog(player);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            player.sendMessage("Your file was created");
        }



    }
}
