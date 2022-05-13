package ru.netology.webtest;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebTest {

    @Test
    public void ShouldSubmitRequest() {
        open("http://localhost:9999/");

        SelenideElement form = $("form[enctype='application/x-www-form-urlencoded']");
        form.$("input[name='name']").setValue("Иван");
        form.$("input[name='phone']").setValue("+79080001234");
        form.$("label[data-test-id='agreement']").click();
        form.$("button[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
