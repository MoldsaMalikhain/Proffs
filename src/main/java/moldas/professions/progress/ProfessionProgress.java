package moldas.professions.progress;

import moldas.professions.progress.data.ProgressMaxValues;

import java.io.Serializable;

public class ProfessionProgress implements Serializable {
    public int primaryProfLvl = 0;
    public int primaryProfProgress = 0;
    public int secondaryProfLvl = 0;
    public int secondaryProfProgress = 0;

    /**
     * @return true if max lvl of primary profession reached
     */
    public boolean primaryMaxLvl() { return primaryProfLvl == ProgressMaxValues.POINTS_TO_LVL_UP; }

    /**
     * @return true if max lvl of secondary profession reached
     */
    public boolean secondaryMaxLvl() { return secondaryProfLvl == ProgressMaxValues.POINTS_TO_LVL_UP; }
}
