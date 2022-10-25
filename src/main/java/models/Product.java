package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    @JsonProperty("category_id")
    private int categoryId;
    @JsonProperty("category_name")
    private String categoryName;

}
