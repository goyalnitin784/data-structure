package ds.array;

import java.util.Stack;

public class Bodmas {

  public void eval(String s) {
    char arr[] = s.toCharArray();
    Stack<String> values = new Stack<>();
    Stack<String> operator = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == ' ') {
        continue;
      }
      if (arr[i] == '(') {
        operator.push(String.valueOf(arr[i]));
      } else if (arr[i] >= '0' && arr[i] <= '9') {
        StringBuilder stringBuilder = new StringBuilder();
        while (arr[i] >= '0' && arr[i] <= '9') {
          stringBuilder.append(arr[i]);
        }
        values.push(stringBuilder.toString());
      } else if (arr[i] == ')') {
        int val = 0;
        while (operator.peek() != "(") {
          values.push(String.valueOf(output(values.pop(), values.pop(), operator.pop())));
        }
        operator.pop();
      } else if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
        while (checkHigherPrecenceForOperator(operator.peek(), String.valueOf(arr[i]))) {
          values.push(String.valueOf(output(values.pop(), values.pop(), operator.pop())));
        }
        operator.push(String.valueOf(arr[i]));
      }
    }
    while (!operator.isEmpty()) {
      values.push(String.valueOf(output(values.pop(), values.pop(), operator.pop())));
    }
    System.out.println(values.pop());
  }

  boolean checkHigherPrecenceForOperator(String char1, String char2) {
    if ((char1 == "+" || char1 == "-") && (char2 == "*" || char2 == "/")) {
      return false;
    }
    return true;
  }

  int output(String char1, String char2, String expression) {
    switch (expression) {
      case "+":
        return Integer.valueOf(char1) + Integer.valueOf(char2);
      case "-":
        return Integer.valueOf(char1) - Integer.valueOf(char2);
      case "*":
        return Integer.valueOf(char1) * Integer.valueOf(char2);
      case "/":
        return Integer.valueOf(char1) / Integer.valueOf(char2);
    }
    return 0;
  }


  public static void main(String[] args) {

  }

}
