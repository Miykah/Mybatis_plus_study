package com.miykah.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miykah.mp.mapper.UserMapper;
import com.miykah.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author miykah
 * @create 2021-11-25 14:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMybatisSpring {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
        int count = userMapper.insert(new User(null, "linjia", "555520", "lilinjia", 22, "6044@qq.com"));
        System.out.println("插入了" + count + "条记录");
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1L);
        System.out.println("user = " + user);
    }

    @Test
    public void testUpdateById(){
        int count = userMapper.updateById(new User(1L, "lalala", "000", "lalala", 20, "lalala@qq.com"));
        System.out.println("有" + count + "条数据被更新");
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("www");
        user.setAge(29);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","lisi");//匹配user_name=lisi的人

        int count = userMapper.update(user, wrapper);
        System.out.println("有" + count + "条数据被更新");
    }

    @Test
    public void testUpdate2(){

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age",22).set("email","2020@qq.com");
        wrapper.eq("user_name","wangwu");

        int count = userMapper.update(null,wrapper);
        System.out.println("有" + count + "条数据被更新");
    }

    @Test
    public void testUpdateById2(){

        User user = new User();
        user.setId(3L);
        user.setPassword("weqewq");

        int count = userMapper.updateById(user);
        System.out.println("有" + count + "条数据被更新");

    }

    @Test
    public void testUpdate3(){
        User user = new User();
        user.setPassword("asdasd");
        user.setMail("qwe@qq.com");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","zhaoliu");

        int count = userMapper.update(user, wrapper);
        System.out.println("有" + count + "条数据被更新");
    }

    @Test
    public void testUpdate4(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("password","ranmaoqi0718");
        wrapper.set("user_name","miykahh");
        wrapper.eq("name","冉茂淇");
        int update = userMapper.update(null, wrapper);
        System.out.println("有" + update + "条数据被更新");
    }

    @Test
    public void testDeleteById(){
        int count = userMapper.deleteById(4L);
        System.out.println("有" + count + "条数据被删除");
    }

    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","wangwu");
        map.put("password","weqewq");
        int count = userMapper.deleteByMap(map);
        System.out.println("有" + count + "条数据被删除");
    }

}
