import com.codeborne.selenide.Configuration;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import pages.PDPPage;

import java.io.IOException;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @Test
    void openGoogle() {
        open("https://google.com");
    }

    @Test
    void changeQtyInCart() {
        PDPPage.addSimpleToCart("tas-128996");
    }

    @Test
    void sashaPostcodeProblem() {
        Configuration.holdBrowserOpen=true;
        open("https://ijsvogeldev.hypernode.io/be-nl/customer/address/new/");
        $("#email").setValue("o.mohylnytskyi@ism-ukraine.com");
        $("#pass").val("ut1rIgkI");
        $("button.login").click();



        $("#zip-be").setValue("10");
        $(".ui-autocomplete li:nth-child(1)").click();


//        Selenide.executeJavaScript("jQuery('#hb-cc-wrap').remove()");
//
//        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        WebElement element = WebDriverRunner.getWebDriver().findElement(By.cssSelector(".make-sticky-header .nav-sections"));
//        js.executeScript("arguments[0].setAttribute('style', 'display: none')", element);


//        if ($("#hb-cc-hide").isDisplayed()) {
//            $("#hb-cc-hide").click();
//        }
    }

    @Test
    void registerCustomerViaAPI() throws IOException {
        Random randomEmailSuffix = new Random();
        String randomEmail = "fake" + randomEmailSuffix.nextInt(99999) + "@mail.ua";


        CloseableHttpClient client = HttpClientBuilder.create().build();
        String requestJSON;
//        if (false) {
//             requestJSON = "{ \"customer\": {"
//                    + "\"dob\": \"" + CustomerData.dateOfBirth + "\","
//                    + "\"email\": \"" + randomEmail + "\","
//                    + "\"firstname\": \"" + CustomerData.firstName + "\","
//                    + "\"lastname\": \"" + CustomerData.lastName + "\","
//                    + "\"gender\": " + CustomerData.genderMaleValue + ","
//                    + "\"addresses\": [ " +
//                    "{"
//                    + "\"country_id\": \"" + CustomerData.countryCode + "\","
//                    + "\"street\": [ \"" + CustomerData.street + "\",\"" + CustomerData.housenumber + "\" ], "
//                    + "\"company\": \"" + CustomerData.company + "\","
//                    + "\"telephone\": \"" + CustomerData.telephone + "\","
//                    + "\"postcode\": \"" + CustomerData.postcode + "\","
//                    + "\"city\": \"" + CustomerData.city + "\","
//                    + "\"firstname\": \"" + CustomerData.firstName + "\","
//                    + "\"lastname\": \"" + CustomerData.lastName + "\","
//                    + "\"default_billing\": " + "true"
//                    + "},{"
//                    + "\"country_id\": \"" + CustomerData.countryCode + "\","
//                    + "\"street\": [ \"" + CustomerData.streetShip + "\",\"" + CustomerData.housenumberShip + "\" ], "
//                    + "\"company\": \"" + CustomerData.company + "\","
//                    + "\"telephone\": \"" + CustomerData.telephoneShip + "\","
//                    + "\"postcode\": \"" + CustomerData.postcodeShip + "\","
//                    + "\"city\": \"" + CustomerData.cityShip + "\","
//                    + "\"firstname\": \"" + CustomerData.firstName + "\","
//                    + "\"lastname\": \"" + CustomerData.lastName + "\","
//                    + "\"default_shipping\": " + "true"
//                    + "}"
//                    + "]"
//                    + "}, \"password\": \"" + CustomerData.passwordValue + "\"}";
//        } else {
            requestJSON = "{ \"customer\": {\"dob\": \"" + "10-09-2000"
                    + "\", \"email\": \"" + randomEmail
                    + "\", \"firstname\": \"" + "Testing"
                    + "\", \"lastname\": \"" + "Account"
                    + "\", \"gender\": " + "1"
                    + " }, \"password\": \"" + "abcABC123!" + "\"}";
//        }

        StringEntity input = new StringEntity(requestJSON, ContentType.APPLICATION_JSON);
        HttpPost post = new HttpPost("https://ijsvogeldev.hypernode.io/rest/V1/customers");
        post.setHeader("Authorization", "Bearer cbr7qau0ogakq29lwkg52ci4qycygps1");
        post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        HttpResponse response2 = client.execute(post);
//        if (response.getStatusLine().getStatusCode() != 200) Assert.fail(); //fail test if customer was not created
    }

    @Test
    void futureTest() {
        open("future");
    }

    @Test
    void secondmethod() {

    }
}
