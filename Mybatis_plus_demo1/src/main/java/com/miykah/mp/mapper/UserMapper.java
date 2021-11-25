package com.miykah.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miykah.mp.pojo.User;

import java.util.List;

/**
 * @author miykah
 * @create 2021-11-25 9:21
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

}
