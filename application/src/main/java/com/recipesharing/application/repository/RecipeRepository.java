package com.recipesharing.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipesharing.application.entity.RecipeEntity;


@Repository

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>{

}
