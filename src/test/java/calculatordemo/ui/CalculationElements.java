package calculatordemo.ui;

import calculatordemo.tasks.Calculate;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalculationElements {
    public static Target RESULT = Target.the("Result calculation").located(By.name("q"));

    public static Target GET_NUMBER (int number){
        return Target.the("Number #"+number).located(By.xpath("//*[@dcg-command=\'"+number+"\']"));
    }

    public static Target GET_OPERATION (Calculate.Operations operation){
        switch (operation){
            case ADD:
                return Target.the("Addition").located(By.xpath("//*[@dcg-command='+']"));
            case SUB:
                return Target.the("Subtraction").located(By.xpath("//*[@dcg-command='-']"));
            case DIV:
                return Target.the("Division").located(By.xpath("//*[@dcg-command='/']"));
            case MUL:
                return Target.the("Multiple").located(By.xpath("//*[@dcg-command='*']"));
            default:
                return null;
        }
    }
}
