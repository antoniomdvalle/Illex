package com.example.illex.mapper;

import com.example.illex.model.Goal;
import com.example.illex.dto.goal.GoalDTO;
import com.example.illex.model.User;

public class GoalMapper {
    public static Goal toEntity(GoalDTO dto, User user){

        Goal goal = new Goal();

        goal.setName(dto.getName());
        goal.setStatus(dto.getStatus());
        goal.setTargetAmount(dto.getTargetAmount());
        goal.setDeadline(dto.getDeadline());

        goal.setUser(user);


        return goal;
    }

    public static GoalDTO toDTO(Goal goal){
        GoalDTO dto = new GoalDTO();

        dto.setName(goal.getName());
        dto.setStatus(goal.getStatus());
        dto.setTargetAmount(goal.getTargetAmount());
        dto.setDeadline(goal.getDeadline());

        return dto;
    }
}
