import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Stack;

public class ExpressionConverter {

    public double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        //loops each component of the string
        for (String component : postfix.split(" ")) {
            if (!isOperator(component)) {
                stack.push(Double.parseDouble(component));
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();
                switch (component) {
                    //push the result
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    default -> throw new IllegalArgumentException("Invalid operator: " + component);
                }
            }
            //stack trace
            System.out.println("Current Index: " + component +
                    "\nStack rn: " + stack + "\n");
        }
        return stack.pop();
    }

    //determines component
    public boolean isOperator(String operator) {
        return List.of("*", "/", "+", "-").contains(operator);
    }






    /*
    //for sorting precedences
    public static boolean hasLowerPrecedence(String op1, String op2) {
        return precedence(op1) < precedence(op2);
    }
    public static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 3;
        };
    }
    */
}




