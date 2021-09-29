package moldas.professions.gui.data;

import moldas.professions.gui.GUIButton;
import moldas.professions.prof.data.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ProfessionMenuData {

    static final GUIButton MINER_BUTTON = new GUIButton(Material.IRON_PICKAXE, ChatColor.GOLD,
            MinerData.PROF_NAME, MinerData.BUTTON_LORE);
    static final GUIButton LUMBERJACK_BUTTON = new GUIButton(Material.IRON_AXE, ChatColor.RED,
            LumberjackData.PROF_NAME, LumberjackData.BUTTON_LORE);
    static final GUIButton FARMER_BUTTON = new GUIButton(Material.IRON_HOE, ChatColor.YELLOW,
            FarmerData.PROF_NAME, FarmerData.BUTTON_LORE);
    static final GUIButton ARCHER_BUTTON = new GUIButton(Material.BOW, ChatColor.DARK_BLUE,
            ArcherData.PROF_NAME, ArcherData.BUTTON_LORE);
    static final GUIButton WARRIOR_BUTTON = new GUIButton(Material.IRON_SWORD, ChatColor.DARK_GREEN,
            WarriorData.PROF_NAME, WarriorData.BUTTON_LORE);
    static final GUIButton BLACKSMITH_BUTTON = new GUIButton(Material.ANVIL, ChatColor.BLACK,
            BlacksmithData.PROF_NAME, BlacksmithData.BUTTON_LORE);
    static final GUIButton ALCHEMIST_BUTTON = new GUIButton(Material.BREWING_STAND, ChatColor.AQUA,
            AlchemistData.PROF_NAME, AlchemistData.BUTTON_LORE);
    static final GUIButton ENCHANTER_BUTTON = new GUIButton(Material.ENCHANTING_TABLE, ChatColor.DARK_PURPLE,
            EnchanterData.PROF_NAME, EnchanterData.BUTTON_LORE);
    static final GUIButton CLOSE_BUTTON = new GUIButton(Material.BARRIER, ChatColor.WHITE, "Close", "");

    public final static ItemStack[] menuItems = {
            MINER_BUTTON.itemStack, LUMBERJACK_BUTTON.itemStack, FARMER_BUTTON.itemStack, ARCHER_BUTTON.itemStack,
            WARRIOR_BUTTON.itemStack, BLACKSMITH_BUTTON.itemStack, ALCHEMIST_BUTTON.itemStack, ENCHANTER_BUTTON.itemStack,
            CLOSE_BUTTON.itemStack };
}
