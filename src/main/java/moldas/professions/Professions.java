package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.commands.tabcompleters.GetProfTabCompleter;
import moldas.professions.commands.tabcompleters.LeaveProfTabCompleter;
import moldas.professions.commands.tabcompleters.StatTabCompleter;
import moldas.professions.prof.listners.Miner;
import moldas.professions.gui.listeners.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Professions extends JavaPlugin {

    PlayerDataHandler playersData = new PlayerDataHandler();

    final Inventory professionPickGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Profession choice");
    final Inventory professionLeaveGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Leave profession");

    @Override
    public void onEnable() {

        this.getCommand("myprof").setExecutor(new MyProf(playersData));
        this.getCommand("getprof").setExecutor(new GetProf(playersData, professionPickGUI));
        this.getCommand("getprof").setTabCompleter(new GetProfTabCompleter());
        this.getCommand("helpprof").setExecutor(new HelpProf());
        this.getCommand("listprof").setExecutor(new ListProf());
        this.getCommand("leaveprof").setExecutor(new LeaveProf(playersData, professionLeaveGUI));
        this.getCommand("leaveprof").setTabCompleter(new LeaveProfTabCompleter(playersData));
        this.getCommand("changestat").setExecutor(new ChangeStat(playersData));
        this.getCommand("changestat").setTabCompleter(new StatTabCompleter());
        this.getCommand("mystats").setExecutor(new MyStats(playersData));

        getServer().getPluginManager().registerEvents(new GlobalListeners(playersData), this);
        getServer().getPluginManager().registerEvents(new Miner(playersData), this);

        getServer().getPluginManager().registerEvents(new ClickEvent(playersData, professionPickGUI, professionLeaveGUI), this);

        System.out.println(ChatColor.YELLOW + "" + "[PLUGIN] " +
                ChatColor.RESET + " prof-plugin is started");
        System.out.println("Profession plugin is Created by AT13, Moldas and ximure");
    }

    @Override
    public void onDisable() {
        //TODO Save players data to database
    }
}
