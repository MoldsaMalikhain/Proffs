package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.commands.tabcompleters.GetProfTabCompleter;
import moldas.professions.commands.tabcompleters.StatTabCompleter;
import moldas.professions.prof.listners.Miner;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Professions extends JavaPlugin {

    PlayerDataHandler playersData = new PlayerDataHandler();

    public static final File STATS_YAML = new File("./plugins/Professions/messages.yml");

    @Override
    public void onEnable() {

        //TODO Read players data from database

        this.getCommand("myprof").setExecutor(new MyProf());
        this.getCommand("getprof").setExecutor(new GetProf(playersData));
        this.getCommand("getprof").setTabCompleter(new GetProfTabCompleter());
        this.getCommand("helpprof").setExecutor(new HelpProf());
        this.getCommand("listprof").setExecutor(new ListProf());
        this.getCommand("leaveprof").setExecutor(new LeaveProf());
        this.getCommand("changestat").setExecutor(new ChangeStat(playersData));
        this.getCommand("changestat").setTabCompleter(new StatTabCompleter());
        this.getCommand("getstats").setExecutor(new GetStats(playersData));

        getServer().getPluginManager().registerEvents(new GlobalListeners(playersData), this);
        getServer().getPluginManager().registerEvents(new Miner(playersData), this);

        System.out.println(ChatColor.YELLOW + "" + ChatColor.BOLD + "PLUGIN:" +
                ChatColor.RESET + " prof-plugin is started");
        System.out.println("Profession plugin is Created by AT13, Moldas and ximure");
    }

    @Override
    public void onDisable() {
        //TODO Save players data to database
    }
}
