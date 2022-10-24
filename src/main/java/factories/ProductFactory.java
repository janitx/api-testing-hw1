package factories;

import models.ProductDto;

public class ProductFactory {
    public static ProductDto create(String command) {
        if (command.equals("productPrice")) {
            ProductDto product = new ProductDto();
            product.setId(1014);
            product.setPrice(6);
            return product;

        } else if (command.equals("productFull")) {
            ProductDto product = new ProductDto();
            product.setId(1005);
            product.setName("Sweatband");
            product.setDescription("This sweatband is very suitable for various sports");
            product.setPrice(6);
            product.setCategoryId(3);
            product.setCategoryName("Active Wear - Unisex");
            return product;

        } else if (command.equals("productMultiVitamins")) {
            return new ProductDto(
                    18,
                    "Multi-Vitamin (90 capsules)",
                    "A daily dose of our Multi-Vitamins fulfills a day’s nutritional needs for over 12 vitamins and minerals.",
                    10.00,
                    4,
                    "Supplements"
            );


        }
        return null;
    }

}
