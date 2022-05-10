package com.controller;


import com.helpers.DefaultResponse;
import com.helpers.LoginResponse;
import com.model.dto.LoginDto;
import com.model.dto.RoleDto;
import com.model.dto.UserDto;
import com.model.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/auth")
public class AuthController {
    //==convertDtoToEntity
    public User convertDtoToEntity (UserDto userDto){
        User user= new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    public User convertDtoLoginToEntity (LoginDto loginDto){
        User user = new User();
        user.setId(loginDto.getId());
        user.setEmail(loginDto.getEmaillogin());
        return  user;
    }

    //==convertEntityToDto
     public UserDto convertEntityToDto ( User userEntity){
        UserDto userdto= new UserDto();
        userdto.setId(userEntity.getId());
        userdto.setEmail(userEntity.getEmail());
        userdto.setFirstName(userEntity.getFirstName());
        userdto.setLastName(userEntity.getLastName());
        return userdto;
    }

    //Injek repository
    @Autowired
    public UserRepository userRepository;

    //create date user
    @PostMapping("/register")
    public DefaultResponse<UserDto> read(@RequestBody UserDto userDto){
        User user = convertDtoToEntity(userDto);
        DefaultResponse<UserDto> response = new DefaultResponse<>();
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if(optional.isPresent()){
            response.setMessage("Error, email sudah ada");
        } else {
            userRepository.save(user);
            response.setMessage("Berhasil Daftar");
            response.setData(userDto);
        }

        return response;
    }

    @PostMapping("/login")
    public LoginResponse<LoginDto> masuk(@RequestBody LoginDto loginDto) {
        User user = convertDtoLoginToEntity(loginDto);
        LoginResponse<LoginDto> resp = new LoginResponse<>();
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmail(loginDto.getEmaillogin()));
        if (optional.isPresent()) {
            resp.setPesan("Error, email tidak terdaftar");
        } else {
            resp.setPesan("Welcome" + user.getFirstName());
        }

        return resp;
    }

    @GetMapping("/list-role")
    public List<RoleDto> listRole(){
        List<RoleDto> listR = new ArrayList<>();
        RoleDto r1 = new RoleDto();
        r1.setPeran("Pengunjung");
        listR.add(r1);

        RoleDto r2 = new RoleDto();
        r2.setPeran("Member");
        listR.add(r2);

        RoleDto r3 = new RoleDto();
        r3.setPeran("Pengunjung");
        listR.add(r3);

        return  listR;
    }







}
