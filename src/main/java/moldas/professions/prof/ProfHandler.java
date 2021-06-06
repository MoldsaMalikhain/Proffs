package moldas.professions.prof;

public class ProfHandler {

    interface ProfChoucer{
        void move();
    }

    public ProfChoucer[] profChoucers = new ProfChoucer[]{
            new ProfChoucer() { public void move() {new Farmer().setAsFarmer(); } },
            new ProfChoucer() { public void move() {new Miner().setAsMiner(); } },
            new ProfChoucer() { public void move() {new Lumberjack().setAsLumberjack(); } },
    };
    public void move(int index){
        profChoucers[index].move();
    }



}
