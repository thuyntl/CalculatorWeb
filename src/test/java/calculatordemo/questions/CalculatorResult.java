package calculatordemo.questions;

import calculatordemo.ui.CalculationElements;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CalculatorResult implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade resultAdditon = CalculationElements.RESULT.resolveFor(actor);
        return resultAdditon.getText();
    }
}
