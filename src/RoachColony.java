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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitPopulation() {
        return initPopulation;
    }

    public void setInitPopulation(int initPopulation) {
        this.initPopulation = initPopulation;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    @Override
    public String toString() {
        return "[" + name + "] [INITIAL POP. = " + initPopulation + "] [G.R. = " + growthRate + "]";
    }
}

