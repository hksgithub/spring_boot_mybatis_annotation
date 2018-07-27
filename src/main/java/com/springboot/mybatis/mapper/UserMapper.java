package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper{

//    mybatis中数据库不能自动识别大写字母，如userName，它只认识user_name，因此需要转换
//    @Results({
//            @Result(column = "user_name",property = "userName")
//    })
    @Select("SELECT * FROM user")
    List<User> findAll();

//    @Results({
//            @Result(column = "user_name",property = "userName")
//    })
    @Insert("INSERT INTO user(id,username,password) VALUES (#{id},#{username},#{password})")
    void addOne(User user);

//    @Results({
//            @Result(column = "user_name",property = "userName")
//    })
    @Update("UPDATE user SET username=#{username},password=#{password} where id=#{id}")
    void update(User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findOne(String id);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void delOne(String id);
}
