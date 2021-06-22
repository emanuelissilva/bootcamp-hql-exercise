package com.bootcamphql.hqlexample.service;

import com.bootcamphql.hqlexample.dto.UserDTO;
import com.bootcamphql.hqlexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAllUsers(){
        return userRepository.findAllUsers();
    }

    public UserDTO findByUserId(Long id){
        return userRepository.findUserById(id);
    }

    public List<UserDTO> findByUsernameContains(String query){
        return userRepository.findByUsernameContains(query);
    }

    public UserDTO saveUser(UserDTO userDTO){
        return userRepository.save(userDTO);
    }

    public void userNewPasswordDTO(String userNewPasswordDTO, Long id){
        userRepository.updateUserPassword(userNewPasswordDTO, id);
    }

    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }

}
