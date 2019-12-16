package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PDPPage {

    public static String addToCartButton = ".add-to-cart .btn-cart";
    public static String goToCartButton = ".pip-cart-info .btn-cart";

    public static void addSimpleToCart(String productUrl)
    {
        open(productUrl);
        $(PDPPage.addToCartButton).click();
        $(PDPPage.goToCartButton).click();
        $(CartPage.cartGrid).shouldBe(Condition.visible);
        assert WebDriverRunner.url().contains("checkout/cart");
    }
}
