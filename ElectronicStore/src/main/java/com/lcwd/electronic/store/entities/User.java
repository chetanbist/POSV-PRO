package com.lcwd.electronic.store.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// entity means it represents a table in database named with User.

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="users")
public class User {

    // @Id acts as primary key
    @Id
    private String userId;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email",unique=true)
    private String email;

    @Column(name="user_password",length=10)
    private String password;

    private String gender;

    @Column(length=1000)
    private String about;

    @Column(name="user_image_name")
    private String imageName;
}

