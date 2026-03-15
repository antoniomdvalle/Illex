package com.example.illex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.illex.dto.goal.GoalDTO;
import com.example.illex.service.GoalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @PostMapping
    public GoalDTO createGoal(@RequestParam Long userId, @Valid @RequestBody GoalDTO dto){
        return goalService.createGoal(userId, dto);
    }

    @GetMapping
    public List<GoalDTO> getGoals(@RequestParam Long userId){
        return goalService.getUserGoals(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id){
        goalService.deleteGoal(id);
    }
}
