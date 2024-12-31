package com.demo.sample.service.impl;

import org.springframework.stereotype.Service;

import com.demo.sample.dto.request.UserRequestDTO;
import com.demo.sample.exception.ResourceNotFoundException;
import com.demo.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int addUser(UserRequestDTO requestDTO) {
        System.out.println("Add user to db");
        if (!requestDTO.getFirstName().equals("Dat")) {
            throw new ResourceNotFoundException("Dat khong ton tai");
        }
        return 0;
    }

}
