package com.thesis.webspajz.model.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JwtRequest implements Serializable {

    private String username;
    private String password;
}
