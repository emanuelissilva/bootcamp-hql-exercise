package com.bootcamphql.hqlexample.controller;

import com.bootcamphql.hqlexample.dto.UserDTO;
import com.bootcamphql.hqlexample.dto.UserNewPasswordDTO;
import com.bootcamphql.hqlexample.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/")
    public List<UserDTO> findByUsernameContains(@RequestParam(value = "query") String query){
        return userService.findByUsernameContains(query);
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findByUserId(id);
    }

    @PostMapping("/create")
    public void createNewUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
    }

    @PostMapping("/save")
    public UserDTO saveNewUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @PutMapping
    public void updateUserPassword(@RequestBody UserNewPasswordDTO userNewPasswordDTO){
        userService.userNewPasswordDTO(userNewPasswordDTO.getNewPassword(), userNewPasswordDTO.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
