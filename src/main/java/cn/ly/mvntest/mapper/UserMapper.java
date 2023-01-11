package cn.ly.mvntest.mapper;

import cn.ly.mvntest.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserByUid(@Param("uid") int uid);

}
