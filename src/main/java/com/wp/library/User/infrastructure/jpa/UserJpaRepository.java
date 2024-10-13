package com.wp.library.User.infrastructure.jpa;

import com.wp.library.User.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
