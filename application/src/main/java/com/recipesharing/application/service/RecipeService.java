package com.recipesharing.application.service;

import java.util.List;
import java.util.Optional;

import com.recipesharing.application.entity.RecipeEntity;

public interface RecipeService {
	List<RecipeEntity> getAllRecipes();
	Optional<RecipeEntity> getRecipeById(Long id);
	RecipeEntity createRecipe(RecipeEntity recipe);
	RecipeEntity updateRecipe(RecipeEntity recipe);
	String deleteRecipe(Long id);
}
