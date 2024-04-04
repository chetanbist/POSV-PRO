package com.lcwd.electronic.store.services.impl;

import com.lcwd.electronic.store.dtos.UserDto;
import com.lcwd.electronic.store.entities.User;
import com.lcwd.electronic.store.exception.ResourceNotFoundException;
import com.lcwd.electronic.store.repositories.UserRepository;
import com.lcwd.electronic.store.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto userDto) {

      String userId=  UUID.randomUUID().toString();
      userDto.setUserId(userId);
        // dto->entity
        User user=dtoToEntity(userDto);
        User savedUser=userrepository.save(user);
        // entity->dto
        UserDto newDto=entityToDto(savedUser);
        return newDto;

    }



    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
      User user=  userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id"));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setImageName(userDto.getImageName());
       User updatedUser= userrepository.save(user);
       UserDto updatedDto=entityToDto( updatedUser);
       return updatedDto;


    }

    @Override
    public void deleteUser(String userId) {
        User user=  userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id"));
        userrepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {
   List<User> users=userrepository.findAll();
   List<UserDto> dtoList=users.stream().map(user->entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto getUserById(String userId) {
        User user=  userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id"));

        return entityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user=  userrepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found with  email"));

        return entityToDto(user);
    }

    @Override
    public List<UserDto> searchUser(String keyword) {

        List<User> users=userrepository.findByNameContaining(keyword);
        List<UserDto> dtoList=users.stream().map(user->entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }
    private UserDto entityToDto(User savedUser) {
//      UserDto userDto=  UserDto.builder()
//                .userId(savedUser.getUserId())
//                .name(savedUser.getName())
//                .email(savedUser.getEmail())
//                .password(savedUser.getPassword())
//                .about(savedUser.getAbout())
//                .gender(savedUser.getGender())
//                .imageName(savedUser.getImageName()).build();


        return mapper.map(savedUser,UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
//      User user=  User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .password(userDto.getPassword())
//                .about(userDto.getAbout())
//                .gender(userDto.getGender())
//              .imageName(userDto.getImageName()).build();


        return  mapper.map(userDto,User.class);
    }
}
