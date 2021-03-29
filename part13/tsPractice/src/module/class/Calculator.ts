export interface Expression {
  operator: string,
  left: number,
  right: number
}

enum OPERATOR {
  "+",
  "-",
  "*",
  "/",
}

console.log('operators:',OPERATOR)

export class Calculator {
  private current = 0;
  private memory = 0;
  private operator: string;

  /**
   *@date 2021/3/23
   * @param digit {string} - 数字
   * @param currentValue {number} - 当前的数值
  */
  protected processDigit(digit: string, currentValue: number) {
    if (digit >= "0" && digit <= "9") {
      return currentValue * 10 + (digit.charCodeAt(0) - "0".charCodeAt(0));
    }
  }

  /**
   *@date 2021/3/23
   * @param operator {string} 操作符
  */
  protected processOperator(operator: string) {
    if (operator in OPERATOR) return operator;
  }

  protected evaluateOperator(expression: Expression): number {
    switch (this.operator) {
      case "+":
        return expression.left + expression.right;
      case "-":
        return expression.left - expression.right;
      case "*":
        return expression.left * expression.right;
      case "/":
        return expression.left / expression.right;
    }
  }

  private evaluate() {
    if (this.operator) {
      this.memory = this.evaluateOperator(
        {
         operator: this.operator,
         left: this.memory,
         right: this.current
        }
      )
    } else {
      this.memory = this.current;
    }
    this.current = 0;
  }

  public handleChar(char: string) {
    if (char === "=") {
      this.evaluate();
      return;
    } else {
      let value = this.processDigit(char, this.current);
      if (value !== undefined) {
        this.current = value;
        return;
      } else {
        let value = this.processOperator(char);
        if (value !== undefined) {
          this.evaluate();
          this.operator = value;
          return;
        }
      }
    }
    throw new Error(`Unsupported input: '${char}'`);
  }

  public getResult() {
    return this.memory;
  }
}

export function test(c: Calculator, input: string) {
  for (let i = 0; i < input.length; i++) {
    c.handleChar(input[i]);
  }
  console.log(`result of '${input}' is '${c.getResult()}'`);
}
