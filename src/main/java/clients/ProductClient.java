package clients;

import constants.EndPoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.MessageDto;
import models.ProductDto;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public static <D> MessageDto create(D productDto) {
        Response response = given().body(productDto)
                .when()
                .post(EndPoints.CREATE)
                .then().log().all()
                .statusCode(201)
                .extract()
                .response();

        String jsonString = response.asString();
        JsonPath jp = new JsonPath(jsonString);

        return new MessageDto(jp.get("message").toString());

    }

    public static <D> MessageDto update(D productDto) {
        Response response = given().body(productDto)
                .when()
                .put(EndPoints.UPDATE)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();

        String jsonString = response.asString();
        JsonPath jp = new JsonPath(jsonString);

        return new MessageDto(jp.get("message").toString());

    }

    public static ProductDto get(int id) {
        return given().log().all()
                .queryParam("id", id)
                .then()
                .statusCode(200)
                .when()
                .get(EndPoints.READ)
                .as(ProductDto.class);
    }

    public static <D> MessageDto delete(D productDto) {
        Response response = given().body(productDto)
                .when()
                .delete(EndPoints.DELETE)
                .then().log().all()
                .statusCode(200)
                .extract()
                .response();

        String jsonString = response.asString();
        JsonPath jp = new JsonPath(jsonString);

        return new MessageDto(jp.get("message").toString());
    }

}
