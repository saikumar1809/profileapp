package com.example.backend.education.resource;

import com.example.backend.Response;
import com.example.backend.address.model.Address;
import com.example.backend.education.model.Education;
import com.example.backend.education.service.implementation.EducationServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/education")
@RequiredArgsConstructor
public class EducationResource {
    private final EducationServiceImplementation educationService;
    @PostMapping("/")
    public ResponseEntity<Response> saveEducation(@RequestBody @Valid Education education){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("education",educationService.create(education)))
                        .message("education created")
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
                        .data(Map.of("education",educationService.getAllByUserId(userId)))
                        .message("education reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
//    @GetMapping("/list")
//    public ResponseEntity<Response> getUsers(){
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(Map.of("users",employmentTypeService.list(30)))
//                        .message("employment retrevied")
//                        .status(OK)
//                        .statusCode((OK.value()))
//                        .build()
//        );
//    }
}
