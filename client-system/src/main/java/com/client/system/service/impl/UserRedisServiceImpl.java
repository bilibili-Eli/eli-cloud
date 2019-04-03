package com.client.system.service.impl;

import com.client.system.exception.EliException;
import com.client.system.mapper.UsersMapper;
import com.client.system.model.Users;
import com.client.system.service.UserRedisService;
import com.client.system.util.EliApiCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRedisServiceImpl extends BaseRedisServiceImpl<String> implements UserRedisService {

    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectAll() throws EliException {
        try {
            List<String> userIdList = getAll();
            if (userIdList == null || userIdList.size() == 0) return null;
            else return usersMapper.selectActivity(getAll());
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public void deleteAll() throws EliException {
        try {
            empty();
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }
}
