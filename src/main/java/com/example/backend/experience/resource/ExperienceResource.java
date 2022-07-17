package com.example.backend.experience.resource;

import com.example.backend.Response;
import com.example.backend.experience.model.experience;
import com.example.backend.experience.model.Experience;
import com.example.backend.experience.service.implementation.ExperienceServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/experience")
@RequiredArgsConstructor
public class ExperienceResource {

    private final ExperienceServiceImplementation experienceService;
    @PostMapping("/")
    public ResponseEntity<Response> saveexperience(@RequestBody @Valid Experience experience){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("experience",experienceService.create(experience)))
                        .message("experience created")
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
                        .data(Map.of("experience",experienceService.getAllByUserId(userId)))
                        .message("experience reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
}
