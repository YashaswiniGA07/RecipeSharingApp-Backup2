package com.recipesharing.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recipesharing.application.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping()
    public ResponseEntity<?> likeRecipe(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean success = likeService.likeRecipe(userId, recipeId);
        if (success) {
            return ResponseEntity.ok("Recipe liked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Recipe already liked by the user.");
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikeRecipe(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean success = likeService.unlikeRecipe(userId, recipeId);
        if (success) {
            return ResponseEntity.ok("Recipe unliked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Recipe not liked by the user.");
        }
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkIfLikedByUser(@RequestParam("userId") Long userId, @RequestParam("recipeId") Long recipeId) {
        boolean liked = likeService.isRecipeLikedByUser(userId, recipeId);
        return ResponseEntity.ok(liked);
    }
}

