public class RoachColony implements Observer{
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
        return String.format("[%s] [INITIAL POP. = %d] [G.R. = %.2f]", name, initPopulation, growthRate);
    }

    public void display(){
        System.out.println(">>> We are " + name + " and we have been notified of a vacancy!");
    }

    @Override
    public void update() {
        display();
    }
}

