package com.recipesharing.application.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

	public LikeEntity() {
		super();
	}

	public LikeEntity(Long likeId, UserEntity user, RecipeEntity recipe) {
		super();
		this.id = likeId;
		this.user = user;
		this.recipe = recipe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}
    
    

   

}
