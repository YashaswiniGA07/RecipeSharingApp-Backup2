package com.recipesharing.application.service;
public interface LikeService {

    boolean likeRecipe(Long userId, Long recipeId);

    boolean unlikeRecipe(Long userId, Long recipeId);

    boolean isRecipeLikedByUser(Long userId, Long recipeId);

}

