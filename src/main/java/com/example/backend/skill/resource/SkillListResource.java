package com.example.backend.skill.resource;

import com.example.backend.Response;
import com.example.backend.skill.model.SkillList;
import com.example.backend.skill.service.implementation.SkillListServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/skill/skills")
@RequiredArgsConstructor
public class SkillListResource {
   private final SkillListServiceImplementation skillListService;
    @PostMapping("/")
    public ResponseEntity<Response> saveAddress(@RequestBody @Valid SkillList SkillList){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("employment",skillListService.create(SkillList)))
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
                        .data(Map.of("skills",skillListService.list(30)))
                        .message("skills retrevied")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }


    @GetMapping("/{id}")

    public ResponseEntity<Response> getSkill(@PathVariable("id") Long addressTypeId ){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Address",skillListService.get(addressTypeId)))
                        .message("skills reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
}
