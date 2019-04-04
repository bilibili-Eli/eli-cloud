package com.client.system.model;

import com.client.system.util.EliRequestUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class EliModel implements Serializable {
    @Column(name = "create_on")
    private Date createOn;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "modify_on")
    private Date modifyOn;
    @Column(name = "modify_by")
    private String modifyBy;
    @Column(name = "owner")
    private String owner;
    @Column(name = "status")
    private String status;

    public void iniInsert(HttpServletRequest request, HashOperations<String, String, String> hashOperations) {
        String userId = EliRequestUtil.getUserId(request, hashOperations);
        setCreateOn(new Date());
        setModifyOn(new Date());
        setCreateBy(userId);
        setModifyBy(userId);
        setOwner(userId);
        setStatus("0");
    }

    public void iniModify(HttpServletRequest request, HashOperations<String, String, String> hashOperations) {
        setModifyBy(EliRequestUtil.getUserId(request, hashOperations));
        setModifyOn(new Date());
    }
}
