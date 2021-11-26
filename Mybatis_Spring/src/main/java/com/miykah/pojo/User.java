package com.miykah.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author miykah
 * @create 2021-11-25 14:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;

}
