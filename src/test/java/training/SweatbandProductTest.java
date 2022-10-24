package training;

import clients.ProductClient;

import factories.MessageFactory;
import factories.ProductFactory;

import models.MessageDto;
import models.ProductDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SweatbandProductTest {

    // Task1. Challenge:Use requests to complete the lifecycle of a resource

    @Test
    public void createSweatband() {
        ProductDto product = ProductFactory.create("productFull");

        MessageDto expectedResult = MessageFactory.create("Product was created.");
        MessageDto actualResult = ProductClient.create(product);
        assertEquals(expectedResult.asString(), actualResult.asString());
    }

    @Test
    public void updateSweatband() {
        ProductDto product = ProductFactory.create("productFull");
        product.setPrice(6);

        MessageDto expectedResult = MessageFactory.create("Product updated");
        MessageDto actualResult = ProductClient.update(product);
        assertEquals(expectedResult.asString(), actualResult.asString());

    }


    @Test
    public void getSweatband() {
        ProductDto product = ProductFactory.create("productFull");

        product.setPrice(5);
        product.setId(1010);
        assertThat(ProductClient.get(product.getId()), samePropertyValuesAs(product));

    }


    @Test
    public void deleteSweatband() {
        ProductDto product = ProductFactory.create("productFull");

        MessageDto expectedResult = MessageFactory.create("Product was deleted.");
        MessageDto actualResult = ProductClient.delete(product);

        assertEquals(expectedResult.asString(), actualResult.asString());
    }

    // Task2.

    @Test
    public void getMultivitamins() {
        ProductDto expectedProduct = ProductFactory.create("productMultiVitamins");
        ProductDto actualProduct = ProductClient.get(18);

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
