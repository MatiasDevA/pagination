package com.pagination.pagination.service.implementacion;


import com.pagination.pagination.domain.User;
import com.pagination.pagination.repository.UserRepository;
import com.pagination.pagination.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl  implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("fetchin users for page {} of size {}", page , size);
        return userRepository.findByNameContaining(name , PageRequest.of(page, size));
    }
}
