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

    @Override
    public String toString() {
        return "[" + name + ", initial pop. of " + initPopulation + ", growth rate of " + growthRate+ "]";
    }
}

