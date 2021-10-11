package moldas.professions.prof;

import moldas.professions.progress.data.ProgressMaxValues;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Profession {

    public String name;
    public int lvl = 1;
    public int progress = 0;

    public Profession(String _name) {
        name = _name;
    }

    /**
     * @return true if max lvl of profession reached
     */
    public boolean maxLvl() {
        return lvl == ProgressMaxValues.POINTS_TO_LVL_UP;
    }
}
