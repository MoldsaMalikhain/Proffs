package moldas.professions.gui.data;

import moldas.professions.gui.GUIButton;
import moldas.professions.prof.data.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;

/**
 * Class where storing all buttons
 */
public class GUIButtons {
    //Usable Profession buttons
    public static final GUIButton MINER_BUTTON = new GUIButton(Material.IRON_PICKAXE, ChatColor.GOLD,
            MinerData.PROF_NAME, MinerData.BUTTON_LORE);
    public static final GUIButton LUMBERJACK_BUTTON = new GUIButton(Material.IRON_AXE, ChatColor.RED,
            LumberjackData.PROF_NAME, LumberjackData.BUTTON_LORE);
    public static final GUIButton FARMER_BUTTON = new GUIButton(Material.IRON_HOE, ChatColor.YELLOW,
            FarmerData.PROF_NAME, FarmerData.BUTTON_LORE);
    public static final GUIButton ARCHER_BUTTON = new GUIButton(Material.BOW, ChatColor.DARK_BLUE,
            ArcherData.PROF_NAME, ArcherData.BUTTON_LORE);
    public static final GUIButton WARRIOR_BUTTON = new GUIButton(Material.IRON_SWORD, ChatColor.DARK_GREEN,
            WarriorData.PROF_NAME, WarriorData.BUTTON_LORE);
    public static final GUIButton BLACKSMITH_BUTTON = new GUIButton(Material.ANVIL, ChatColor.DARK_GRAY,
            BlacksmithData.PROF_NAME, BlacksmithData.BUTTON_LORE);
    public static final GUIButton ALCHEMIST_BUTTON = new GUIButton(Material.BREWING_STAND, ChatColor.AQUA,
            AlchemistData.PROF_NAME, AlchemistData.BUTTON_LORE);
    public static final GUIButton ENCHANTER_BUTTON = new GUIButton(Material.ENCHANTING_TABLE, ChatColor.DARK_PURPLE,
            EnchanterData.PROF_NAME, EnchanterData.BUTTON_LORE);

    //Custom buttons for show player data in GUI
    public static GUIButton MINER_BUTTON_CUSTOM = new GUIButton(Material.IRON_PICKAXE, ChatColor.GOLD,
            MinerData.PROF_NAME);
    public static GUIButton LUMBERJACK_BUTTON_CUSTOM = new GUIButton(Material.IRON_AXE, ChatColor.RED,
            LumberjackData.PROF_NAME);
    public static GUIButton FARMER_BUTTON_CUSTOM = new GUIButton(Material.IRON_HOE, ChatColor.YELLOW,
            FarmerData.PROF_NAME);
    public static GUIButton ARCHER_BUTTON_CUSTOM = new GUIButton(Material.BOW, ChatColor.DARK_BLUE,
            ArcherData.PROF_NAME);
    public static GUIButton WARRIOR_BUTTON_CUSTOM = new GUIButton(Material.IRON_SWORD, ChatColor.DARK_GREEN,
            WarriorData.PROF_NAME);
    public static GUIButton BLACKSMITH_BUTTON_CUSTOM = new GUIButton(Material.ANVIL, ChatColor.DARK_GRAY,
            BlacksmithData.PROF_NAME);
    public static GUIButton ALCHEMIST_BUTTON_CUSTOM = new GUIButton(Material.BREWING_STAND, ChatColor.AQUA,
            AlchemistData.PROF_NAME);
    public static GUIButton ENCHANTER_BUTTON_CUSTOM = new GUIButton(Material.ENCHANTING_TABLE, ChatColor.DARK_PURPLE,
            EnchanterData.PROF_NAME);

    //Message buttons
    public static final GUIButton PRIMARY_PROF_NOT_DEFINED = new GUIButton(Material.BOOK, ChatColor.LIGHT_PURPLE,
            "Primary", ChatColor.GOLD + "You don`t have your primary profession yet",
            ChatColor.UNDERLINE + "*Press on this button to get it*");
    public static final GUIButton SECONDARY_PROF_NOT_DEFINED = new GUIButton(Material.BOOK, ChatColor.LIGHT_PURPLE,
            "Secondary", ChatColor.GOLD + "You don`t have your secondary profession yet",
            ChatColor.UNDERLINE + "*Press on this button to get it*");

    //Control buttons
    public static final GUIButton CLOSE_BUTTON = new GUIButton(Material.BARRIER, ChatColor.WHITE,
            "Close", ChatColor.WHITE + "Close the UI");
    public static final GUIButton NONE_BUTTON = new GUIButton(Material.WHITE_STAINED_GLASS_PANE, ChatColor.GOLD,
            "~There nothing here right now~", "");
    public static final GUIButton YES_BUTTON = new GUIButton(Material.GREEN_WOOL, ChatColor.GREEN, "Yes",
            "Yes, i agree");
    public static final GUIButton NO_BUTTON = new GUIButton(Material.RED_WOOL, ChatColor.GREEN, "No",
            "No, i disagree");
}
