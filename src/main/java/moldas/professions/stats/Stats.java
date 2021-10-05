package moldas.professions.stats;

import moldas.professions.progress.data.ProgressMaxValues;

public abstract class Stats {

    int lvl = 1;
    int progress = 0;

    public void setLvl(int _lvl) { lvl = _lvl; }

    public int getLvl() { return lvl; }

    /**
     * Method which will execute when stat is lvl up
     */
    public abstract void onLvlUp();

    public void addProgress(int amount) {
        this.progress += amount;
        if((lvl * ProgressMaxValues.POINTS_TO_LVL_UP) <= progress) {
            progress -= lvl * ProgressMaxValues.POINTS_TO_LVL_UP;
            lvl++;
            onLvlUp();
        }
    }

    public int getProgress() { return progress; }
}
