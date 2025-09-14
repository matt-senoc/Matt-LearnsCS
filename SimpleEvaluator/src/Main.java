import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //helper class instance
        ExpressionConverter converter = new ExpressionConverter();

        //comm
        System.out.println("Enter Postfix Expression: ");
        String  expression = sc.nextLine();

        try {
            double result = converter.evaluatePostfix(expression);
            System.out.println("Evaluation Result: " + result);
        } catch (Exception e) {
            System.out.println("\nTry again.");
        } finally {
            sc.close();
        }

    }
}


