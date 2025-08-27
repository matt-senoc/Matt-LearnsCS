import javax.swing.*;

public class Main_WaterTank {

    public static void main(String[] args) {
        //resets the tank
        WaterTankClass tank = null;

        JOptionPane.showMessageDialog(null,  "Hello!");

        //tank option user prompt
        String[] tankOptions = {"Home Tank (200L)", "Building Tank (20,000L)"};
        int tankChosen = JOptionPane.showOptionDialog(null, "Select a tank to use: ",
                "Select a Water Tank", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, tankOptions, tankOptions[0]);

        //Ask the user to choose which tank to use.
        if (tankChosen == 0) {
            tank = new HomeTank();
            JOptionPane.showMessageDialog(null,"Home Tank was selected.\nTank Capacity : 200");
        } else if (tankChosen == 1) {
            tank = new BuildingTank();
            JOptionPane.showMessageDialog(null, "Building Tank was selected.\nTank Capacity : 20000");
        } else {

        }

        //Allow the user to fill or use water.
        do {
            String[] zaActionOptions = {"Fill with wotah", "Use za wotah", "Check Tank Usage"};
            int zaActionChoice = JOptionPane.showOptionDialog(null, "Choose Action: ", "Tank Optionz.",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, zaActionOptions, zaActionOptions[0]);

            try {
                switch (zaActionChoice) {
                    case 0:
                        String fillAmountStr = JOptionPane.showInputDialog("Enter liters to fill: ");
                        if (fillAmountStr == null) continue;

                        int fillAmount = Integer.parseInt(fillAmountStr);
                        tank.fillTank(fillAmount);
                        break;
                    case 1:
                        String useAmountStr = JOptionPane.showInputDialog("Enter liters to use: ");
                        if (useAmountStr == null) continue; // User cancelled
                        int useAmount = Integer.parseInt(useAmountStr);
                        tank.useWater(useAmount);
                        break;
                    case 2: // Check Status
                        tank.checkStatus();
                        break;
                    default: // User closed the dialog
                        // Exit the loop if the user closes the action choice dialog.
                        JOptionPane.showMessageDialog(null, "Exiting program.");
                        System.exit(0);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Choice!");
            }

        } while (tank.getCurrentWaterLevel() > 0 && tank.getCurrentWaterLevel() < tank.getCapacity());

        if (tank.getCurrentWaterLevel() <= 0) {
            JOptionPane.showMessageDialog(null, "Tank is Empty!\nProgram ended.");
        } else {
            JOptionPane.showMessageDialog(null, "Tank is Full!\nProgram ended.");
        }
    }
}








//  **NOTING TO SEE HERE**
//JOptionPane.showMessageDialog("Hi, welcome to the Water Tank Monitoring Program!");
// Req #3
//        new WaterTankGUI();
//JOptionPane.showMessageDialog(null, "");
//    private DefaultTableModel model;
//    WaterTankGUI() {
//    setTitle("Water Tank Monitoring System.");
//    setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    int WIDTH = 720;
//    int HEIGHT = 360;
//
//    setSize(WIDTH, HEIGHT);
//    setLocationRelativeTo(null);
//    setResizable(false);
//    setAlwaysOnTop(true);
//    setLayout(null);
//    setVisible(true);
//
//    JPanel wholeP = new JPanel();
//    wholeP.setLayout(null);
//    }