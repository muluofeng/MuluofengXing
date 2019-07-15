package com.example.xing.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiexingxing
 * @Created by 2018-11-25 12:44 AM.
 */
@Data
@Builder
public class RegisterUserDTO  implements Serializable {

    private String username;

    private String password;
}
