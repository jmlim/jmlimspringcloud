package io.jmlim.userservice.user.service;

import io.jmlim.userservice.user.dto.UserDto;
import io.jmlim.userservice.user.entity.User;

public interface UsersService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<User> getUserByAll();
}
