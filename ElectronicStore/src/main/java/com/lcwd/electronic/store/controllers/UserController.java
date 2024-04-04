package com.lcwd.electronic.store.controllers;

import com.lcwd.electronic.store.dtos.ApiResponseMessage;
import com.lcwd.electronic.store.dtos.UserDto;
import com.lcwd.electronic.store.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping
    public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto)
    {
        UserDto userDto1=UserService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
  @PutMapping("/{userId}")
   public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId,
      @RequestBody UserDto userDto)
    {
   UserDto updatedUserDto=UserService.updateUser(userDto,userId);
   return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);

    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleleteUser(@PathVariable String userId)

    {
        UserService.deleteUser(userId);
        ApiResponseMessage message=ApiResponseMessage.builder().message("User deleted").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    // get all
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity<>(UserService.getAllUser(),HttpStatus.OK);

    }
    // get single
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId)
    {
        return new ResponseEntity<>(UserService.getUserById(userId),HttpStatus.OK);

    }
    // get by email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUsrByEmail(@PathVariable String email)
    {
        return new ResponseEntity<>(UserService.getUserByEmail(email),HttpStatus.OK);
    }
    // search user
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<UserDto>> getsearchUser(@PathVariable String keywords)
    {
 return new ResponseEntity<>(UserService.searchUser(keywords),HttpStatus.OK);

    }
}
