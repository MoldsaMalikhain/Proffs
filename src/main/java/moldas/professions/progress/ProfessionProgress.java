package moldas.professions.progress;

public class ProfessionProgress {
    public int primaryProfLvl = 0;
    public int primaryProfProgress = 0;
    public int secondaryProfLvl = 0;
    public int secondaryProfProgress = 0;

    public int pointsToLvlUp = 100;

    public boolean primaryMaxLvl() {
        int maxPrimaryLvl = 100;
        return primaryProfLvl != maxPrimaryLvl;
    }

    public boolean secondaryMaxLvl() {
        int maxSecondaryLvl = 100;
        return secondaryProfLvl != maxSecondaryLvl;
    }
}
