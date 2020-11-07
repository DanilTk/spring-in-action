package pl.dan.demo.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import pl.dan.demo.model.Ingredient;

public interface IngredientRepo extends CrudRepository<Ingredient, String> {
}
