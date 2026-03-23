# MadMath

**MadMath** is a Java class for tokenizing , evaluating, and verifying mathematical expressions. It provides methods to convert expressions to Reverse Polish Notation (RPN), solve them, and validate input strings safely.

## Features

- Tokenize mathematical expressions into operands and operators  
- Convert infix expressions to Reverse Polish Notation (RPN)  
- Solve expressions in RPN format  
- Solve string expressions safely with validation  
- Verify expression correctness before solving  
- Handle operator precedence and numeric checks  

## Methods

### `tokenize(String expression)`
Splits a mathematical expression string into individual tokens (numbers and operators).  

**Parameters:**  
- `expression` – The expression to tokenize  

**Returns:**  
- `ArrayList<String>` – ArrayList of tokens  

---

### `toRpn(ArrayList<String>> tokens)`
Converts a list of tokens in infix notation to Reverse Polish Notation (RPN).  

**Parameters:**  
- `tokens` – ArrayList of tokens in infix order  

**Returns:**  
- `ArrayList<String>` – Tokens in RPN order  

---

### `solverpn(ArrayList<String> rpnTokens)`
Evaluates a mathematical expression given in RPN.  

**Parameters:**  
- `rpnTokens` – ArrayList of tokens in RPN  

**Returns:**  
- `String` – The result of the expression  

---

### `solvestring(String expression)`
Parses a string expression and returns the calculated result.  

**Parameters:**  
- `expression` – A valid mathematical expression as a string  

**Returns:**  
- `String` – The evaluated result  

---

### `verfiyproblem(String expression)`
Checks if a mathematical expression is syntactically valid.  

**Parameters:**  
- `expression` – The expression to verify  

**Returns:**  
- `boolean` – `true` if the expression is valid, otherwise `false`  

---

### `solvestringsafe(String expression)`
Safely evaluates a string expression after verification. Throws exceptions for invalid expressions.  

**Parameters:**  
- `expression` – A string expression to solve  

**Returns:**  
- `String` – Result of the expression  

---

### `isoperator(String token)`
Checks if a token is a recognized operator (`+`, `-`, `*`, `/`, `^`).  

**Parameters:**  
- `token` – A single string token  

**Returns:**  
- `boolean` – `true` if the token is an operator  

---

### `precedence(String operator)`
Returns the precedence level of an operator. Higher numbers indicate higher precedence.  

**Parameters:**  
- `operator` – Operator string  

**Returns:**  
- `int` – Precedence value  

---

### `checknum(String token)`
Checks if a token is a valid number.  

**Parameters:**  
- `token` – Token to check  

**Returns:**  
- `boolean` – `true` if the token is numeric  

---

## Example Usage

```java
MadMath math = new MadMath();
String expression = "3+4*2/(1-5)^2";
if (math.verfiyproblem(expression)) {
    String result = math.solvestringsafe(expression);
    System.out.println("Result: " + result);
}
