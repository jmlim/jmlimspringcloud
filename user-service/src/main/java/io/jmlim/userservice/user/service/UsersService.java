package io.jmlim.userservice.user.service;

import io.jmlim.userservice.user.dto.UserDto;
import io.jmlim.userservice.user.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<User> getUserByAll();

    UserDto getUserDetailsByEmail(String username);
}
