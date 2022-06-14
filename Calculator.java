import java.io.*;

/** Methods for performing arithmetic calculations. */
class Arithmetic {
  public static float add(float num1, float num2) {
    return num1 + num2;
  }
  public static float subtract(float num1, float num2) {
    return num1 - num2;
  }
  public static float divide(float num1, float num2) {
    return num1 / num2;
  }
  public static float multiply(float num1, float num2) {
    return num1 * num2;
  }
  public static float modulo(float num1, float num2) {
    return num1 % num2;
  }
  public static float square(float num1) {
    return num1 * num1;
  }
  public static float cube(float num1) {
    return num1 * num1 * num1;
  }
}

/** The calculator program. */
public class Calculator {
  public static void main(String[] args) {

    while (true) {
      // prompt user for input of calculator arguments. If null, prompt again.
      String input = getUserInput("Enter your equation:");
      if (input == null) {
        System.out.println("Please enter an equation.");
        continue;
      }

      // Split string into token at each space and store tokens into an array of Strings
      String[] tokens = input.split(" ");

      // Assign the string token at element 0 to act as the operator
      String operator = tokens[0];

      if (shouldQuit(operator)){
        System.out.println("Quitting the program. Goodbye!");
        break;
      }
     
      Float num1, num2;
      try {
        num1 = Float.parseFloat(tokens[1]);

        if (tokens.length >= 3) {
          num2 = Float.parseFloat(tokens[2]);

        } else {
          num2 = 0f;
        }
      
      // Handle errors
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: enter at least 1 number.");
        continue;
      } catch (NumberFormatException e) {
        System.out.println("Error: not able to parse the numbers you entered.");
        continue;
      }

      // Check type of operator and call the appropriate method depending on the operator type
      Float result;
      switch (operator) {
        case "+":
          result = Arithmetic.add(num1, num2);
          break;
        case "-":
          result = Arithmetic.subtract(num1, num2);
          break;
        case "*":
          result = Arithmetic.multiply(num1, num2);
          break;
        case "/":
          result = Arithmetic.divide(num1, num2);
          break;
        case "%":
          result = Arithmetic.modulo(num1, num2);
          break;
        case "**":
          result = Arithmetic.square(num1);
          break;
        case "***":
          result = Arithmetic.cube(num1);
          break;
        default:
          result = null;
          break;
      }

      if (result == null) {
        System.out.println("Invalid operator.");
      } else {
        System.out.println("=> " + result);
      }
    }
  }

  /** Works exactly like Python's input() function. 
   This is an example of a helper function.
  */
  static String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");
    try {
      BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) {
        return null;
      }
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    return inputLine;
  }


// operator argument should come from tokenize function
// check if operator is q
// quit if so
  static Boolean shouldQuit(String operator) {
    return operator.toLowerCase().equals("q");
  }

  
  // 1. String[] tokens = tokenize(input)
      // input==> split to array items
  
  // 2. String operator = extractOperator(tokens)
      // assign index 0 to operator, assign index 1 and 2 to float variables
      // checking for any values that are exceptions and throw out exception messages. 

  // 3. if (shouldQuit(operator)){
      // System.out.println("Quitting the program. Goodbye!");
      // break;
      // }
    

}
