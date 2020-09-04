package com.sysware.ke.tbs.service;

import com.sysware.ke.tbs.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 获取待处理的数据
     *
     * @param mod 用多少取余
     * @param remainder 余数为多少
     * @param topNum 取前多少个数据
     */
    List<User> getUsers(int mod, List<Integer> remainder, int topNum);

    List<User> getUserList(int mod, List<String> remainder, int topNum);

    /**
     * 更新用户信息
     */
    int update(User task);
}
