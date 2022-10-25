package factories;

public class ProductFactory {
    public static models.Product create(Product command) {
        if (command.equals(ProductFactory.Product.PRODUCT_PRICE)) {
            models.Product product = new models.Product();
            product.setId(1014);
            product.setPrice(6);
            return product;

        } else if (command.equals(ProductFactory.Product.PRODUCT_FULL)) {
            models.Product product = new models.Product();
            product.setId(1005);
            product.setName("Sweatband");
            product.setDescription("This sweatband is very suitable for various sports");
            product.setPrice(6);
            product.setCategoryId(3);
            product.setCategoryName("Active Wear - Unisex");
            return product;

        } else if (command.equals(ProductFactory.Product.PRODUCT_MULTIVITAMINS)) {
            return new models.Product(
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

    public enum Product {
        PRODUCT_PRICE,
        PRODUCT_FULL,
        PRODUCT_MULTIVITAMINS
    }

}
