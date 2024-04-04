package com.lcwd.electronic.store.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    private String userId;


   //@Size(min=3,max=15,message = "Invalid name1!!")
    private String name;

     //@Email(message = "Invalid  user Email1!!")
    private String email;

    //@NotBlank(message = "password is reqire!!")
    private String password;

    //@Size(min=4,max=6,message = "Invalid gender!")
    private String gender;

    //@NotBlank(message = "write something about yourself..!!")
    private String about;

   // @pattern matching
    // custom validator
    private String imageName;

}
