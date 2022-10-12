package training;

import constants.EndPoints;
import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SweatbandProductTest {

    // Task1. Challenge:Use requests to complete the lifecycle of a resource

    @Test
    public void createSweatband() {
        Product product = new Product(
                "Sweatband",
                "This sweatband is very suitable for various sports",
                5,
                3
        );

        var response = given().body(product).when().post(EndPoints.CREATE).then();
        response.log().body();
    }


    @Test
    public void updateSweatband() {
        Product product = new Product(
                1004,
                "Sweatband",
                "This sweatband is very suitable for various sports",
                6,
                3
        );
        var response = given().body(product).when().put(EndPoints.UPDATE).then();
        response.log().body();
    }


    @Test
    public void getSweatband() {
        var response =
                given().
                        queryParam("id", 1004).
                        when().
                        get(EndPoints.READ).
                        then();
        response.log().body();
    }

    @Test
    public void deleteSweatband() {
            String body = """
                {
                "id": 1003
                }
                """;
        var response = given().body(body).when().delete(EndPoints.DELETE).then();
        response.log().body();
    }

    // Task2. Challenge:Verify API response
    @Test
    public void getMultivitamins() {
            given().
                queryParam("id", 18).
                when().
                get(EndPoints.READ).
                then().
                assertThat().
                statusCode(200).
                header("Content-Type", equalTo("application/json")).
                body("id", equalTo("18")).
                body("name", equalTo("Multi-Vitamin (90 capsules)")).
                body("description", equalTo("A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals.")).
                body("price", equalTo("10.00")).
                body("category_id", equalTo("4")).
                body("category_name", equalTo("Supplements"))
               .log().body();


    }



}
