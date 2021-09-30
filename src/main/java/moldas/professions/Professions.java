package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.commands.guicommands.GetProf;
import moldas.professions.commands.guicommands.LeaveProf;
import moldas.professions.commands.tabcompleters.DeletePlayerProfTabCompleter;
import moldas.professions.commands.tabcompleters.SetPlayerProfTabCompleter;
import moldas.professions.commands.tabcompleters.StatTabCompleter;
import moldas.professions.database.DatabaseDAO;
import moldas.professions.database.PlayerDAO;
import moldas.professions.gui.listeners.ClickEvent;
import moldas.professions.prof.listners.Miner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class Professions extends JavaPlugin {
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    PlayerDataHandler playersData = new PlayerDataHandler();
    final DatabaseDAO databaseDAO = new DatabaseDAO();
    final PlayerDAO playerDAO = new PlayerDAO(databaseDAO);
    private final Logger logger = Bukkit.getLogger();

    final Inventory professionPickGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Profession choice");
    final Inventory professionLeaveGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Leave profession");

    private final File DATABASE_FILE = new File("./plugins/professions/player_data.db");
    private final File PLUGIN_FOLDER = new File("./plugins/professions");
    public static final String DATABASE_URL = "jdbc:sqlite:./plugins/professions/player_data.db";

    @Override
    public void onEnable() {
        // creating plugin folder if it doesn't exist
        if (!PLUGIN_FOLDER.exists()) {
            if (!PLUGIN_FOLDER.mkdirs()) {
                logger.info(ANSI_RED + "[Professions] Plugin folder cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
            }
        }
        // creating database file if it doesn't exist...
        if (!DATABASE_FILE.exists()) {
            if (!databaseDAO.createDatabase()) {
                logger.info(ANSI_RED + "[Professions] Database file cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
            }
            // ...and table
            if (!databaseDAO.createPlayerDataTable()) {
                logger.info(ANSI_RED + "[Professions] Database table cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
            }
        }

        this.getCommand("myprof").setExecutor(new MyProf(playersData));
        this.getCommand("getprof").setExecutor(new GetProf(professionPickGUI));
        this.getCommand("setplayerprof").setExecutor(new SetPlayerProf(playersData));
        this.getCommand("setplayerprof").setTabCompleter(new SetPlayerProfTabCompleter());
        this.getCommand("helpprof").setExecutor(new HelpProf());
        this.getCommand("leaveprof").setExecutor(new LeaveProf(professionLeaveGUI, playersData));
        this.getCommand("deleteplayerprof").setExecutor(new DeletePlayerProf(playersData));
        this.getCommand("deleteplayerprof").setTabCompleter(new DeletePlayerProfTabCompleter(playersData));
        this.getCommand("changestat").setExecutor(new ChangeStat(playersData));
        this.getCommand("changestat").setTabCompleter(new StatTabCompleter());
        this.getCommand("mystats").setExecutor(new MyStats(playersData));

        getServer().getPluginManager().registerEvents(new GlobalListeners(playersData, playerDAO), this);
        getServer().getPluginManager().registerEvents(new Miner(playersData), this);

        getServer().getPluginManager().registerEvents(new ClickEvent(playersData, professionPickGUI, professionLeaveGUI), this);

        logger.info(ANSI_GREEN + "[Professions] Plugin started successfully" + ANSI_RESET);
    }

    @Override
    public void onDisable() {
        //TODO: Save players data to database
    }
}
