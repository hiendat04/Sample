package com.demo.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sample.configuraion.Translator;
import com.demo.sample.dto.request.UserRequestDTO;
import com.demo.sample.dto.response.ResponseData;
import com.demo.sample.dto.response.ResponseError;
import com.demo.sample.exception.ResourceNotFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
public class UserController {

    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            log.info("Request add user = {} {}", userRequestDTO.getFirstName(), userRequestDTO.getLastName());
            return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), 1);
        } catch (ResourceNotFoundException e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@Min(1) @PathVariable int userId, @RequestBody UserRequestDTO userRequestDTO) {
        log.info("Request update user id = {}", userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.upd.success"));
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@Min(1) @PathVariable int userId, @Min(1) @RequestParam int status) {
        log.info("Request change user status, usrId = {}", userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User status updated successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {
        log.info("Request delete user with id  = {}", userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@PathVariable long userId) {
        log.info("Request user id = {}", userId);
        return new ResponseData<>(HttpStatus.OK.value(), "User fetched successfully",
                new UserRequestDTO("Dat", "Mai", "0909592960", "hiendat04@gmail.com"));

    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @Min(10) @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseData<>(HttpStatus.OK.value(), "All users fetched successfully",
                List.of(new UserRequestDTO("Dat", "Mai", "0909592960", "hiendat04@gmail.com"),
                        new UserRequestDTO("Dat", "Mai", "0909592960", "hiendat04@gmail.com")));
    }

}
