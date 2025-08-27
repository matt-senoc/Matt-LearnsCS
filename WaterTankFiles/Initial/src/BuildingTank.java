import javax.swing.*;

class BuildingTank extends WaterTankClass {
    public BuildingTank() {
        super(20000);
    }
    @Override
    public void fillTank(int liters) {
        if (liters <= 0) {
            JOptionPane.showMessageDialog(null, "Please enter a positive number of liters to fill.");
            return;
        }
        if (currentWaterLevel + liters > capacity) {
            JOptionPane.showMessageDialog(null, "Cannot add " + liters + " liters.\nTank will overflow. \nSpace available: " + (capacity - currentWaterLevel) + " liters.");
            int added = capacity - currentWaterLevel;
            currentWaterLevel = capacity;
            JOptionPane.showMessageDialog(null, added + " liters only added.\nCurrent level: " + currentWaterLevel + "/" + capacity);
        } else {
            currentWaterLevel += liters;
            JOptionPane.showMessageDialog(null, liters + " liters added. Current level: " + currentWaterLevel + "/" + capacity);
        }
    }

    @Override
    public void useWater(int liters) {
        if (liters <= 0) {
            JOptionPane.showMessageDialog(null, "Please enter a positive number of liters to use.");
            return;
        }
        if (currentWaterLevel - liters < 0) {
            JOptionPane.showMessageDialog(null, "Cannot use " + liters + " liters. Not enough water. \nWater available: " + currentWaterLevel + " liters.");
            int used = currentWaterLevel;
            currentWaterLevel = 0;
            JOptionPane.showMessageDialog(null, used + " liters used. Current level: " + currentWaterLevel + "/" + capacity);
        } else {
            currentWaterLevel -= liters;
            JOptionPane.showMessageDialog(null, liters + " liters used. Current level: " + currentWaterLevel + "/" + capacity);
        }
    }

    @Override
    public void checkStatus() {
        String status;
        if (currentWaterLevel == capacity) {
            status = "Tank is Full.";
        } else if (currentWaterLevel == 0) {
            status = "Tank is Empty.";
        } else {
            status = "Tank is In Use.";
        }
        JOptionPane.showMessageDialog(null, status + "\nCurrent level: " + currentWaterLevel + "/" + capacity);
    }
}
