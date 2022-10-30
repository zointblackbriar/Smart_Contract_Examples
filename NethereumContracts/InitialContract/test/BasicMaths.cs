
namespace MathOperations {
public class BasicMaths {
    public double Add(double num1, double num2) {
        return num1 + num2; 
    }

    public double Subtraction(double num1, double num2) {
        return num1 - num2; 
    }

    public double Dividend(double num1, double num2) {
        if(num2 > 0) {
            return num1 / num2; 
        } 
        return 0;
    }
}
}
