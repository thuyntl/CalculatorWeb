package calculatordemo.features.search;

import calculatordemo.questions.CalculatorResult;
import calculatordemo.tasks.Calculate;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import calculatordemo.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class CalculatorStory {

    Actor thuy = Actor.named("Thuy");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    @Ignore
    public void annaCanBrowseTheWeb() {
        thuy.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_the_result_of_add_between_two_numbers() {

        givenThat(thuy).wasAbleTo(openTheApplication);

        when(thuy).attemptsTo(
                Calculate.add().between(5).and(4)
        );

        then(thuy).should(
               seeThat(new CalculatorResult(), endsWith("9"))
        );
    }

    @Test
    public void show_the_result_of_minus_between_two_numbers() {

        givenThat(thuy).wasAbleTo(openTheApplication);

        when(thuy).attemptsTo(
                Calculate.minus().between(5).and(4)
        );

        then(thuy).should(
                seeThat(new CalculatorResult(), endsWith("1"))
        );
    }

    @Test
    public void show_the_result_of_divide_between_two_numbers() {

        givenThat(thuy).wasAbleTo(openTheApplication);

        when(thuy).attemptsTo(
                Calculate.divide().between(5).and(4)
        );

        then(thuy).should(
                seeThat(new CalculatorResult(), endsWith("1.25"))
        );
    }

    @Test
    public void show_the_result_of_multiply_between_two_numbers() {

        givenThat(thuy).wasAbleTo(openTheApplication);

        when(thuy).attemptsTo(
                Calculate.multiply().between(5).and(4)
        );

        then(thuy).should(
                seeThat(new CalculatorResult(), endsWith("20"))
        );
    }
}