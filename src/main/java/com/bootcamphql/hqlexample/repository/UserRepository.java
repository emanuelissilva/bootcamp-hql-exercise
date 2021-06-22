package com.bootcamphql.hqlexample.repository;

import com.bootcamphql.hqlexample.dto.UserDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<UserDTO, Long>{

    @Query("select user from UserDTO user")
    List<UserDTO> findAllUsers();

    @Query("select user from UserDTO user where user.username like concat('%', :query, '%')")
    List<UserDTO> findByUsernameContains(String query);

    @Query("from UserDTO user where user.id=:id")
    UserDTO findUserById(Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into UserDTO user(username, password) values (:username, :password)", nativeQuery = true)
    void createUser(UserDTO userDTO);

    @Transactional
    @Modifying
    @Query("update UserDTO user set user.password = :newPassword where user.id = :id")
    void updateUserPassword(String newPassword, Long id);

    @Transactional
    @Modifying
    @Query("delete from UserDTO user where user.id = :id")
    void deleteUser(Long id);
}
