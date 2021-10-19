package moldas.professions.prof.listners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractProfessionListener extends Event implements Cancellable {
    Player player;
    String professionName;
    Set<Material> alchemistBlocks = new HashSet<>();
    Set<Material> archerBlocks = new HashSet<>();
    Set<Material> blacksmithBlocks = new HashSet<>();
    Set<Material> enchanterBlocks = new HashSet<>();
    Set<Material> farmerBlocks = new HashSet<>();
    Set<Material> lumberjackBlocks = new HashSet<>();
    Set<Material> minerBlocks = new HashSet<>();
    Set<Material> warriorBlocks = new HashSet<>();
    {
        // TODO: add another profession blocks
        // Lumberjack blocks
        lumberjackBlocks.add(Material.OAK_LOG);
        lumberjackBlocks.add(Material.ACACIA_LOG);
        lumberjackBlocks.add(Material.BIRCH_LOG);
        lumberjackBlocks.add(Material.DARK_OAK_LOG);
        lumberjackBlocks.add(Material.JUNGLE_LOG);
        lumberjackBlocks.add(Material.SPRUCE_LOG);
    }

    public AbstractProfessionListener(Player player, String professionName) {
        this.player = player;
        this.professionName = professionName;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {

    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
