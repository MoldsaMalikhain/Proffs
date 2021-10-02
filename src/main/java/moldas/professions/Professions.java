package moldas.professions;

import moldas.professions.commands.*;
import moldas.professions.commands.guicommands.GetProf;
import moldas.professions.commands.guicommands.LeaveProf;
import moldas.professions.commands.guicommands.MyProf;
import moldas.professions.commands.tabcompleters.DeletePlayerProfTabCompleter;
import moldas.professions.commands.tabcompleters.SetPlayerProfTabCompleter;
import moldas.professions.commands.tabcompleters.StatTabCompleter;
import moldas.professions.database.DatabaseManager;
import moldas.professions.database.PlayerDAO;
import moldas.professions.gui.listeners.GUIClickEvent;
import moldas.professions.prof.listners.Miner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class Professions extends JavaPlugin {
    // ANSI color for logger
    public final static String ANSI_GREEN = "\u001B[32m";
    public final static String ANSI_RED = "\u001B[31m";
    public final static String ANSI_RESET = "\u001B[0m";

    private final Logger logger = Bukkit.getLogger();

    // database manipulation objects
    DatabaseManager databaseManager = new DatabaseManager();
    final PlayerDAO playerDAO = new PlayerDAO(databaseManager, logger);

    PlayerDataHandler playersData = new PlayerDataHandler();

    final Inventory professionPickGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Profession choice");
    final Inventory professionLeaveGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Leave profession");
    final Inventory myProfessionGUI = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE + "My professions");

    // paths to crucial plugin directories
    private final File DATABASE_FILE = new File("./plugins/professions/player_data.db");
    private final File PLUGIN_FOLDER = new File("./plugins/professions");
    // db url which databaseManager will use to create connection, write data etc
    public static final String DATABASE_URL = "jdbc:sqlite:./plugins/professions/player_data.db";

    @Override
    public void onEnable() {
        // creating plugin folder if it doesn't exist
        if (!PLUGIN_FOLDER.exists()) {
            if (!PLUGIN_FOLDER.mkdirs()) {
                logger.info(ANSI_RED + "[Professions] Plugin folder cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
                // TODO: plugin shutdown
            }
        }
        // creating database file if it doesn't exist...
        if (!DATABASE_FILE.exists()) {
            if (!databaseManager.createDatabase()) {
                logger.info(ANSI_RED + "[Professions] Database file cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
                // TODO: plugin shutdown
            }
            // ...and table
            if (!databaseManager.createPlayerdataTable()) {
                logger.info(ANSI_RED + "[Professions] Database table cannot be created. Plugin will shutdown now"
                        + ANSI_RESET);
                // TODO: plugin shutdown and database file deletion
            }
        }

        this.getCommand("myprof").setExecutor(new MyProf(playersData, myProfessionGUI));
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

        getServer().getPluginManager().registerEvents(new GUIClickEvent(playersData, professionPickGUI, professionLeaveGUI, myProfessionGUI), this);

        logger.info(ANSI_GREEN + "[Professions] Plugin started successfully" + ANSI_RESET);
    }

    @Override
    public void onDisable() {
        //TODO: Save players data to database
    }
}
