package com.example.backend.address.Resource;

import com.example.backend.Response;
import com.example.backend.address.Service.implementation.AddressTypeServiceImplementation;
import com.example.backend.address.model.Address;
import com.example.backend.address.model.Address_Type;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/address/addressType")
@RequiredArgsConstructor
public class AddressTypeResource {

    private final AddressTypeServiceImplementation addressTypeService;
    @PostMapping("/")
    public ResponseEntity<Response> saveAddress(@RequestBody @Valid Address_Type addressType){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user",addressTypeService.create(addressType)))
                        .message("addressType created")
                        .status(CREATED)
                        .statusCode((CREATED.value()))
                        .build()
        );




    }


    @GetMapping("/{id}")

    public ResponseEntity<Response> getAddress(@PathVariable("id") Long addressTypeId ){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Address",addressTypeService.get(addressTypeId)))
                        .message("addressType reterived")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }

}
