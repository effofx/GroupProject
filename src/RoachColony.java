public class RoachColony {
    private String name;
    private int initPopulation;
    private double growthRate;

    public RoachColony(){
        this("no name", 0, 0);
    }

    public RoachColony(String name, int initPopulation, double growthRate){
        this.name = name;
        this.initPopulation = initPopulation;
        this.growthRate = growthRate;
    }

    public void throwParty(){

    }
}

