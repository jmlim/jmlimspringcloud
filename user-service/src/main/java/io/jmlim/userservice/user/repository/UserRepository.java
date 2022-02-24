package io.jmlim.userservice.user.repository;

import io.jmlim.userservice.user.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserId(String userId);
}
