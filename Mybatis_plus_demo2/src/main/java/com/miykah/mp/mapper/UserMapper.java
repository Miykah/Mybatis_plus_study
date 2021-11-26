package com.miykah.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miykah.mp.pojo.User;

/**
 * @author miykah
 * @create 2021-11-25 14:20
 */
public interface UserMapper extends BaseMapper<User> {

    User findById(Long id);

}
