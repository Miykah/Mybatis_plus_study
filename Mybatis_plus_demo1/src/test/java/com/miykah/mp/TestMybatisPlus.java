package com.miykah.mp;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.miykah.mp.mapper.UserMapper;
import com.miykah.mp.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author miykah
 * @create 2021-11-25 9:25
 */
public class TestMybatisPlus {

    @Test
    public void findAll() throws IOException {

        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<User> users = mapper.findAll();

        List<User> users = mapper.selectList(null);

        for (User user : users) {
            System.out.println(user);
        }

    }

}
