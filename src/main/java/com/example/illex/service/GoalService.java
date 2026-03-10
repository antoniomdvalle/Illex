package com.example.illex.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.illex.dto.goal.GoalDTO;
import com.example.illex.mapper.GoalMapper;
import com.example.illex.model.Goal;
import com.example.illex.model.User;
import com.example.illex.repository.GoalRepository;
import com.example.illex.repository.UserRepository;

@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public GoalService(GoalRepository goalRepository, UserRepository userRepository){
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    public GoalDTO createGoal(Long userId, GoalDTO dto){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Goal goal = GoalMapper.toEntity(dto, user);
        Goal saved = goalRepository.save(goal);
        return GoalMapper.toDTO(saved);
    }


    public List<GoalDTO> getUserGoals(Long userId){
        List<Goal> goals = goalRepository.findByUserId(userId);

        return goals.stream().map(GoalMapper::toDTO).collect(Collectors.toList());
    }


    public void deleteGoal(Long goalId){
        if(!goalRepository.existsById(goalId)){
            throw new RuntimeException("Goal not found");
        }
        goalRepository.deleteById(goalId);
    }
}
