package com.example.backend.Resource;

import com.example.backend.model.Response;
import com.example.backend.model.User;
import com.example.backend.service.implementation.UserServiceImplementation;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserServiceImplementation userService;
    @GetMapping("/list")
    public ResponseEntity<Response> getUsers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("users",userService.list(30)))
                        .message("users retrevied")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") Long id)  {
        User user=userService.get(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user",user))
                        .message("user retrevied")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );
    }
    @PostMapping("/signup")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid User user) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("user",userService.create(user)))
                        .message("user created")
                        .status(CREATED)
                        .statusCode((CREATED.value()))
                        .build()
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id")Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted",userService.delete(id)))
                        .message("user deleted")
                        .status(OK)
                        .statusCode((OK.value()))
                        .build()
        );

    }
}
    git remote set-url origin https://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@github.com/Saikumar1809/profileapp.git