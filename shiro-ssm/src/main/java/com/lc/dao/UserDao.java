package com.lc.dao;

import com.lc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User getUserByUserName(String userName);
    //分页
    public List<User> getUserByPage(@Param("from") Integer from,@Param("lineSize") Integer lineSize);
    //获取记录数
    public int getCount();


}
