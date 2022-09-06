package com.pagination.pagination.resource;


import com.pagination.pagination.domain.HttpResponse;
import com.pagination.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.time.LocalDateTime.now;
import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserResources {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUser(@RequestParam Optional<String> name,
                                                @RequestParam Optional<Integer> page,
                                                @RequestParam Optional<Integer> size) throws InterruptedException {
       // TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(Map.of("page", userService.getUsers(name.orElse(""),page.orElse(0),size.orElse(10))))
                        .message("Users Retrieve")
                        .status(HttpStatus.OK)
                        .statusCode(OK)
                        .build()
                        );


    }
}
