package training;

import clients.ProductClient;
import factories.ProductFactory;

import models.Message;
import models.Product;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SweatbandProductTest {

    // Task1. Challenge:Use requests to complete the lifecycle of a resource

    @Test
    public void createSweatband() {
        Product product = ProductFactory.create(ProductFactory.Product.PRODUCT_FULL);

        Message actualResult = ProductClient.create(product);

        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo("Product was created.");

    }

    @Test
    public void updateSweatband() {
        Product product = ProductFactory.create(ProductFactory.Product.PRODUCT_FULL);
        product.setPrice(6);

        Message actualResult = ProductClient.update(product);

        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo("Product updated");

    }


    @Test
    public void getSweatband() {
        Product product = ProductFactory.create(ProductFactory.Product.PRODUCT_FULL);

        product.setId(1010);

        Product actualResult = ProductClient.get(product.getId());

        assertThat(actualResult.getId()).as("Wrong id").isEqualTo(1010);

    }

    @Test
    public void deleteSweatband() {
        Product product = ProductFactory.create(ProductFactory.Product.PRODUCT_FULL);

        Message actualResult = ProductClient.delete(product);

        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo("Product was deleted.");
    }

    // Task2.

    @Test
    public void getMultivitamins() {
        Product expectedProduct = ProductFactory.create(ProductFactory.Product.PRODUCT_MULTIVITAMINS);
        Product actualProduct = ProductClient.get(18);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualProduct.getId()).as("Wrong id").isEqualTo(expectedProduct.getId());
        softAssertions.assertThat(actualProduct.getName()).as("Wrong name").isEqualTo(expectedProduct.getName());
        softAssertions.assertThat(actualProduct.getDescription()).as("Wrong description").isEqualTo(expectedProduct.getDescription());
        softAssertions.assertThat(actualProduct.getPrice()).as("Wrong price").isEqualTo(expectedProduct.getPrice());
        softAssertions.assertThat(actualProduct.getCategoryId()).as("Wrong category").isEqualTo(expectedProduct.getCategoryId());
        softAssertions.assertThat(actualProduct.getCategoryName()).as("Wrong category").isEqualTo(expectedProduct.getCategoryName());
        softAssertions.assertAll();
    }

}
