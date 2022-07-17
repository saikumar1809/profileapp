package com.example.backend.skill.resource;

import com.example.backend.Response;
import com.example.backend.skill.model.Skill;
import com.example.backend.skill.service.implementation.SkillServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/skill/")
@RequiredArgsConstructor
public class SkillResource {

    private final SkillServiceImplementation skillService;
    @PostMapping("/")
    public ResponseEntity<Response> saveSkill(@RequestBody @Valid Skill skill){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Skill",skillService.create(skill)))
                        .message("Skill created")
                        .status(CREATED)
                        .statusCode((CREATED.value()))
                        .build()
        );
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Response> getAddress(@PathVariable("userId") Long userId ){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Skill",skillService.getAllByUserId(userId)))
                        .message("Skill reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
}
