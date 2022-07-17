package com.example.backend.experience.resource;

import com.example.backend.Response;
import com.example.backend.address.model.Address_Type;
import com.example.backend.experience.model.EmploymentType;
import com.example.backend.experience.service.implementation.EmploymentTypeServiceImplementation;
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
@RequestMapping("/user/experience/employment-type")
@RequiredArgsConstructor
public class EmploymentTypeResource {
   private final EmploymentTypeServiceImplementation employmentTypeService;
    @PostMapping("/")
    public ResponseEntity<Response> saveAddress(@RequestBody @Valid EmploymentType employmentType){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("employment",employmentTypeService.create(employmentType)))
                        .message("addressType created")
                        .status(CREATED)
                        .statusCode((CREATED.value()))
                        .build()
        );




    }
    @GetMapping("/list")
    public ResponseEntity<Response> getUsers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("users",employmentTypeService.list(30)))
                        .message("employment retrevied")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }


    @GetMapping("/{id}")

    public ResponseEntity<Response> getAddress(@PathVariable("id") Long addressTypeId ){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Address",employmentTypeService.get(addressTypeId)))
                        .message("employment type reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
}
