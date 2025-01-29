package DesignPatterns.Behavorial.Interpretor.Example1;

public class Driver {
    public static void main(String[] args) {
        // (5 + 3) - 2
        Expression number1 = new NumberExpression(5);
        Expression number2 = new NumberExpression(3);
        Expression number3 = new NumberExpression(2);

        // 5 + 3
        Expression addition = new AddExpression(number1, number2);

        // (5 + 3) - 2
        Expression subtraction = new SubtractExpression(addition, number3);

        // Interpret and print the result
        System.out.println("Result: " + subtraction.interpret());
    }

}
