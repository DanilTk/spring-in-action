package pl.dan.demo.repository;

import pl.dan.demo.model.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
