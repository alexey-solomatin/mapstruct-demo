package com.smartech.mapstructdemo.mapper;

import com.smartech.mapstructdemo.controller.dto.CreateUserRequest;
import com.smartech.mapstructdemo.controller.dto.User;
import com.smartech.mapstructdemo.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", ignore = true) // typical because ids are often auto-generated
    @Mapping(target = "username", source = "username") // may be omitted because field names are the same
    // not a very complex transformation
    @Mapping(target = "firstName", expression = """
        java(com.smartech.mapstructdemo.util.NameUtils.getNamePart(createUserRequest.getFullName(), 0))
        """)
    @Mapping(target = "lastName", expression = """
        java(com.smartech.mapstructdemo.util.NameUtils.getNamePart(createUserRequest.getFullName(), 1))
        """)
    @Mapping(target = "gender", ignore = true) // not specifying the gender at the moment
    @Mapping(target = "email", source = "email", defaultExpression = """
        java(createUserRequest.getUsername() + "@fide.org")
        """)
    @Mapping(target = "status", constant = "ACTIVE") // a new user is always active
    UserEntity map(CreateUserRequest createUserRequest);

    /*
    // The afterMap method can be used for complex transformations.
    @AfterMapping
    public void afterMap(@MappingTarget UserEntity userEntity, CreateUserRequest createUserRequest) {
        // Use anything you can imagine for your mapping from CreateUserRequest to UserEntity,
        // but you need to convert an interface to an abstract class.
    }
     */

    // TODO: it's an exercise for you!
    User map(UserEntity userEntity);
}
