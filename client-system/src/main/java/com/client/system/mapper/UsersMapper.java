package com.client.system.mapper;

import com.client.system.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UsersMapper extends Mapper<Users> {
    @Override
    List<Users> selectAll();

    List<Users> selectActivity(@Param(value = "userIdList") List<String> userIdList);
}
