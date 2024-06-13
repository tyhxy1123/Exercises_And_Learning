package com.javacode2018.chat03.demo04.mapper;

import com.javacode2018.chat03.demo04.model.UserFindDto;
import com.javacode2018.chat03.demo04.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    UserModel getByName(String name);
    List<UserModel> getByMap(Map<String, Object> map);
    List<UserModel> getByUserFindDto(UserFindDto ufd);
    UserModel getByIdOrName(@Param("userId") Long id, @Param("userName")String name);
    List<UserModel> getListByIdCollection(Collection<Long> idCollection);
    List<UserModel> getListByIdList(List<Long> idList);

    /**
     * begin to use ResultHandler interface in iBatis/myBatis
     */
    void getList(ResultHandler<UserModel> resultHandler);
}
