package pl.dan.demo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private Long id;
    @NotNull
    @Size(min = 5, message = "At least 5 chars")
    private String name;
    @Size(min = 1, message = "Choose at least 1")
    private List<Ingredient> ingredients;
    private Date createdAt;
}
