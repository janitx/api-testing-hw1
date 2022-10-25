package clients;

import constants.EndPoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Message;
import models.Product;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public static <D> Message create(D productDto) {

        return given().body(productDto)
                .given().log().all()
                .then()
                .statusCode(201)
                .when()
                .post(EndPoints.CREATE)
                .as(Message.class);


    }

    public static <D> Message update(D productDto) {
        return given().body(productDto)
                .given().log().all()
                .then()
                .statusCode(200)
                .when()
                .put(EndPoints.UPDATE)
                .as(Message.class);

    }

    public static Product get(int id) {
        return given().log().all()
                .queryParam("id", id)
                .then()
                .statusCode(200)
                .when()
                .get(EndPoints.READ)
                .as(Product.class);
    }

    public static <D> Message delete(D productDto) {
        return given().body(productDto)
                .given().log().all()
                .then()
                .statusCode(200)
                .when()
                .delete(EndPoints.DELETE)
                .as(Message.class);


    }

}
