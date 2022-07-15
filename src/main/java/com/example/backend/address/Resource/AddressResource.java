package com.example.backend.address.Resource;

import com.example.backend.Response;
import com.example.backend.address.Service.implementation.AddressServiceImplementation;
import com.example.backend.address.model.Address;
import com.example.backend.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user/address")
@RequiredArgsConstructor
public class AddressResource {
private final AddressServiceImplementation addressService;

@PostMapping("/")
public ResponseEntity<Response> saveAddress(@RequestBody @Valid Address address){
    return ResponseEntity.ok(
            Response.builder()
                    .timeStamp(now())
                    .data(Map.of("user",addressService.create(address)))
                    .message("address created")
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
                    .data(Map.of("Address",addressService.get(userId)))
                    .message("address reterived")
                    .status(OK)
                    .statusCode((OK.value()))
                    .build()
    );
}
}
