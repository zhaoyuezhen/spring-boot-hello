package com.sts.springboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.sts.springboot.dao.Users;

@Mapper
public interface MstUsersMapper {
    int deleteByPrimaryKey(String username);

    int insert(Users record);

    Users selectByPrimaryKey(String username);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);
    
    String selectAuthorityByLoginId(String loginId);
    
}