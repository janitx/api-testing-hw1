package training;

import constants.EndPoints;
import io.restassured.response.Response;
import models.Product;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SweatbandProductTest {

    // Task1. Challenge:Use requests to complete the lifecycle of a resource

    @Test
    public void createSweatband() {

        Product product = new Product();
        product.setName("Sweatband");
        product.setDescription("This sweatband is very suitable for various sports");
        product.setPrice(5);
        product.setCategoryId(3);

        Response response = given().body(product)
                .when()
                .post(EndPoints.CREATE)
                .then().log().all()
                .statusCode(201)
                .extract()
                .response();

        String expectedResult = """
                {"message":"Product was created."}""";

        assertEquals(expectedResult, response.asString());
    }


    @Test
    public void updateSweatband() {
        Product product = new Product();
        product.setId(1004);
        product.setPrice(6);


        Response response = given().body(product)
                .when()
                .put(EndPoints.UPDATE)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();

        String expectedResult = """
                {"message":"Product updated"}""";

        assertEquals(expectedResult, response.asString());
    }


    @Test
    public void getSweatband() {
        Product expectedProduct = new Product(
                1004,
                "Sweatband",
                "This sweatband is very suitable for various sports",
                6.00,
                3,
                "Active Wear - Unisex"
        );


        Product actualProduct =
                given().log().all()
                        .queryParam("id", "1004")
                        .then()
                        .statusCode(200)
                        .when()
                        .get(EndPoints.READ)
                        .as(Product.class);
        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));

    }


    @Test
    public void deleteSweatband() {
        String body = """
                {
                "id": 1013
                }
                """;
        Response response = given().body(body)
                .when()
                .delete(EndPoints.DELETE)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();

        String expectedResult = """
                {"message":"Product was deleted."}""";

        assertEquals(expectedResult, response.asString());
    }

    // Task2.

    @Test
    public void getMultivitamins() {
        Product expectedProduct = new Product(
                18,
                "Multi-Vitamin (90 capsules)",
                "A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals.",
                10.00,
                4,
                "Supplements"
        );


        Product actualProduct =
                given().log().all()
                        .queryParam("id", expectedProduct.getId())
                        .then()
                        .statusCode(200)
                        .when()
                        .get(EndPoints.READ)
                        .as(Product.class);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualProduct.getId()).isEqualTo(expectedProduct.getId());
        softAssertions.assertThat(actualProduct.getName()).isEqualTo(expectedProduct.getName());
        softAssertions.assertThat(actualProduct.getDescription()).isEqualTo(expectedProduct.getDescription());
        softAssertions.assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
        softAssertions.assertThat(actualProduct.getCategoryId()).isEqualTo(expectedProduct.getCategoryId());
        softAssertions.assertThat(actualProduct.getCategoryName()).isEqualTo(expectedProduct.getCategoryName());
        softAssertions.assertAll();


    }


}
