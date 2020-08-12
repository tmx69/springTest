package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class UserController {

    @PostMapping(value = "login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody JsonNode userJSON) throws Exception {
        User user = new User();
//        try {
            if (userJSON.findPath("name").toString().isEmpty()) {
                return new ResponseEntity<Object>("Enter Name", HttpStatus.BAD_REQUEST);
            }
            user.setName(userJSON.findPath("name").textValue());
            user.setOrg(userJSON.findPath("org").textValue());
            user.setSecret(userJSON.findPath("secret").textValue());
//        } catch (Exception e ) {
//            System.out.println("EX: " + e.getMessage());
//            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
