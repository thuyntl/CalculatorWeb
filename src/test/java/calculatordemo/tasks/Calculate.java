package calculatordemo.tasks;

import calculatordemo.ui.CalculationElements;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Calculate implements Task {
    public enum Operations{
        ADD, DIV, SUB, MUL
    }
    public Operations operations;
    public int firstNumber;
    public int secondNumber;

    public Calculate(Operations operation, int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber= secondNumber;
        this.operations = operation;
    }

    public static CalculatorBuilder add() {
        return new CalculatorBuilder(Operations.ADD);
    }

    public static CalculatorBuilder minus() {
        return new CalculatorBuilder(Operations.SUB);
    }

    public static CalculatorBuilder divide() {
        return new CalculatorBuilder(Operations.DIV);
    }

    public static CalculatorBuilder multiply() {
        return new CalculatorBuilder(Operations.MUL);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CalculationElements.GET_NUMBER(this.firstNumber)),
                Click.on(CalculationElements.GET_OPERATION(this.operations)),
                Click.on(CalculationElements.GET_NUMBER(this.secondNumber))
        );
    }

    public static class CalculatorBuilder {
        private Operations operation;
        private int firstNumber;
        private int secondNumber;

        public CalculatorBuilder(Operations operation) {
            this.operation = operation;
        }

        public CalculatorBuilder between(int firstNumber) {
            this.firstNumber = firstNumber;
            return this;
        }

        public Calculate and(int secondNumber) {
            this.secondNumber = secondNumber;
            return instrumented(Calculate.class, this.operation, this.firstNumber, this.secondNumber);
        }
    }
}
