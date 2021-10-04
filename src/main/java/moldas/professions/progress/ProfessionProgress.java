package moldas.professions.progress;

import java.io.Serializable;

public class ProfessionProgress implements Serializable {
    public int primaryProfLvl = 0;
    public int primaryProfProgress = 0;
    public int secondaryProfLvl = 0;
    public int secondaryProfProgress = 0;

    public int pointsToLvlUp = 100;
    public int maxLvl = 100;

    /**
     * @return true if max lvl of primary profession reached
     */
    public boolean primaryMaxLvl() { return primaryProfLvl == maxLvl; }

    /**
     * @return true if max lvl of secondary profession reached
     */
    public boolean secondaryMaxLvl() { return secondaryProfLvl == maxLvl; }
}
