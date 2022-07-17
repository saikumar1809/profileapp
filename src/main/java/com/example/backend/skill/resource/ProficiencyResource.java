package com.example.backend.skill.resource;

import com.example.backend.Response;
import com.example.backend.skill.model.Proficiency;
import com.example.backend.skill.service.implementation.ProficiencyServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/skill/proficiency")
@RequiredArgsConstructor
public class ProficiencyResource {
   private final ProficiencyServiceImplementation proficiencyService;
    @PostMapping("/")
    public ResponseEntity<Response> saveAddress(@RequestBody @Valid Proficiency proficiency){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("employment",proficiencyService.create(proficiency)))
                        .message("addressType created")
                        .status(CREATED)
                        .statusCode((CREATED.value()))
                        .build()
        );




    }
    @GetMapping("/list")
    public ResponseEntity<Response> getSkills(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("skills",proficiencyService.list(30)))
                        .message("skills retrevied")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }


    @GetMapping("/{id}")

    public ResponseEntity<Response> getSkill(@PathVariable("id") Long proficiencyId ){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Address",proficiencyService.get(proficiencyId)))
                        .message("skills reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
}
