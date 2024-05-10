package com.recipesharing.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.application.entity.LikeEntity;
@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);

    void deleteByUserIdAndRecipeId(Long userId, Long recipeId);
}
