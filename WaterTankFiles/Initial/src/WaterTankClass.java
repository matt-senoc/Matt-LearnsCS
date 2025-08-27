abstract public class WaterTankClass {

    // Req #1
    protected int capacity;
    protected int currentWaterLevel;

        // Req abstract methods:
        abstract void fillTank(int liters);
        abstract void useWater(int liters);
        abstract void checkStatus();

    // ZA WATER TANK PROPERTIES
    public WaterTankClass(int capacity) {
        this.capacity = capacity;
        this.currentWaterLevel = 0;
    }

    // TO HELP ZE WHILE LOOP
    public int getCurrentWaterLevel() {
        return currentWaterLevel;
    }
    public int getCapacity() {
        return capacity;
    }
}

