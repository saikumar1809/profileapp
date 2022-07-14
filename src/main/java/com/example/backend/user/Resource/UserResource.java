package com.example.backend.user.Resource;

import com.example.backend.user.model.Login;
import com.example.backend.user.model.Response;
import com.example.backend.user.model.User;
import com.example.backend.user.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

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
//    @GetMapping(path="/{email}")
//    public ResponseEntity<Response> getUserByMail(@PathVariable("email") String email)  {
//        User user=userService.getByEmail(email);
//        System.out.println("email ki vasthundi");
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timeStamp(now())
//                        .data(Map.of("user",user))
//                        .message("user retrevied")
//                        .status(OK)
//                        .statusCode((OK.value()))
//                        .build()
//        );
//    }

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
    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody @Valid Login details) {

        if (userService.verifyLogin(details.getEmail(), details.getPassword())){
            System.out.println("coming to login");
            User user=userService.getByEmail(details.getEmail());
            user.setIsLogin(true);
            userService.update(user);//updating the login
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("id",user.getId()))
                            .message("user logged in success fully")
                            .status(OK)
                            .statusCode((OK.value()))
                            .build()
            );
        }
        else{
            System.out.println("coming to login failed");
            User user=userService.getByEmail(details.getEmail());
            user.setIsLogin(false);
            System.out.println(user.toString());
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("id", "-1"))
                            .message("invalid credentials")
                            .status(UNAUTHORIZED)
                            .statusCode((UNAUTHORIZED.value()))
                            .build()
            );
        }


        }


    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id")Long id){
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
