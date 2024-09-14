package com.learning.productservice.commons;

import com.learning.productservice.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {
    private final RestTemplate restTemplate;
    public AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate= restTemplate;
    }
    public UserDto ValidateToken(String token){
        ResponseEntity<UserDto> userDtoResponseEntity = restTemplate.postForEntity("http://localhost:8181/users/validate/" + token, null, UserDto.class);
        return userDtoResponseEntity.getBody();
    }
}
