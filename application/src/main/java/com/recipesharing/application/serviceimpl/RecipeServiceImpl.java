package com.recipesharing.application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.application.entity.RecipeEntity;
import com.recipesharing.application.repository.RecipeRepository;
import com.recipesharing.application.service.RecipeService;


@Service
public class RecipeServiceImpl implements RecipeService {
	private final RecipeRepository reciperepo;


	@Autowired
	public RecipeServiceImpl(RecipeRepository reciperepo)
	{
		this.reciperepo=reciperepo;
	}


	@Override
	public List<RecipeEntity> getAllRecipes() {
		// TODO Auto-generated method stub
		return reciperepo.findAll();
	}

	@Override
	public Optional<RecipeEntity> getRecipeById(Long id) {
		// TODO Auto-generated method stub
		return reciperepo.findById(id);
	}

	@Override
	public RecipeEntity createRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		return reciperepo.save(recipe);
	}

	@Override
	public RecipeEntity updateRecipe(RecipeEntity recipe) {
		// TODO Auto-generated method stub
		Long id = recipe.getRecipeId(); 
	    Optional<RecipeEntity> existingRecipeOptional = reciperepo.findById(id);
	    
	    if (existingRecipeOptional.isPresent()) {
	        RecipeEntity existingRecipe = existingRecipeOptional.get();
	        existingRecipe.setTitle(recipe.getTitle());
	        existingRecipe.setDescription(recipe.getDescription());
	        existingRecipe.setIngredients(recipe.getIngredients());
	        existingRecipe.setPreperationSteps(recipe.getPreperationSteps());
	        existingRecipe.setCategory(recipe.getCategory());
	        existingRecipe.setCuisine(recipe.getCuisine());
	        existingRecipe.setDifficulty(recipe.getDifficulty());
	        
	        
	        return reciperepo.save(existingRecipe);
	    } else {
	        // Recipe with the given ID not found
	        throw new RuntimeException("Recipe not found with ID: " + id);
	    }
	}

	@Override
	public String deleteRecipe(Long id) {
		// TODO Auto-generated method stub
		reciperepo.deleteById(id);
		return "Recipe Deleted Succesfully";
		
	}
	
	
	
	
}