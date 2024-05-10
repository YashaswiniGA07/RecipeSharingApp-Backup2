package com.recipesharing.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.application.entity.LikeEntity;
import com.recipesharing.application.entity.RecipeEntity;
import com.recipesharing.application.entity.UserEntity;
import com.recipesharing.application.repository.LikeRepository;
import com.recipesharing.application.repository.RecipeRepository;
import com.recipesharing.application.repository.UserRepository;
import com.recipesharing.application.service.LikeService;

import jakarta.transaction.Transactional;


@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private RecipeRepository recipeRepository; 

    @Override
    @Transactional
    public boolean likeRecipe(Long userId, Long recipeId) {
        if (!likeRepository.existsByUserIdAndRecipeId(userId, recipeId)) {
            UserEntity user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            RecipeEntity recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));

            LikeEntity like = new LikeEntity();
            like.setUser(user);
            like.setRecipe(recipe);
            likeRepository.save(like);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean unlikeRecipe(Long userId, Long recipeId) {
        if (likeRepository.existsByUserIdAndRecipeId(userId, recipeId)) {
            likeRepository.deleteByUserIdAndRecipeId(userId, recipeId);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean isRecipeLikedByUser(Long userId, Long recipeId) {
        return likeRepository.existsByUserIdAndRecipeId(userId, recipeId);
    }
}
