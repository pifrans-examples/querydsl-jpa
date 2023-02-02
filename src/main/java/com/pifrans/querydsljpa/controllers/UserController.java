package com.pifrans.querydsljpa.controllers;

import com.pifrans.querydsljpa.domains.dtos.UserDTO;
import com.pifrans.querydsljpa.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO.All>> findAll(@RequestParam(defaultValue = "") String name,
                                                     @RequestParam(defaultValue = "0") Integer minAge,
                                                     @RequestParam(defaultValue = "150") Integer maxAge) {
        List<UserDTO.All> list = userService.filterByNameAndAgeMinMax(name, minAge, maxAge);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<UserDTO.All>> filterByAll(UserDTO.Filter params) {
        UserDTO.Filter filter = UserDTO.Filter.check(params);
        List<UserDTO.All> list = userService.filterByAll(filter);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<UserDTO.All>> saveAll(@Validated @RequestBody List<UserDTO.Save> body) {
        List<UserDTO.All> list = userService.saveAll(body);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
}
