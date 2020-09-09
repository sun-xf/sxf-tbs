package com.sysware.ke.tbs.service.impl;

import com.sysware.ke.tbs.domain.User;
import com.sysware.ke.tbs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers(int mod, List<Integer> taskIdList, int topNum) {
        List<User> allUsers = UserDao.getAllUsers();
        log.info("用户总人数：{}", allUsers.size());

        List<User> result = new ArrayList<>(allUsers.size());
        try{
            for (User user : allUsers) {
                if(taskIdList.contains(user.getId() % mod) && user.getStatus() == 0){
                    result.add(user);
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        /*Stream<User> userStream = allUsers.stream()
                .filter(user -> taskIdList.contains(user.getId() % mod) && user.getStatus() == 0);
        Stream<User> limit = userStream.limit(topNum);
        return limit.collect(Collectors.toList());*/

        return result.stream().limit(topNum).collect(Collectors.toList());
    }

    @Override
    public List<User> getUserList(int mod, List<String> userNameList, int topNum) {
        return UserDao.getAllUsers().stream()
                .filter(user -> userNameList.contains(user.getName().substring(0,1)) && user.getStatus() == 0)
                .limit(topNum)
                .collect(Collectors.toList());
    }

    @Override
    public int update(User task) {
        List<User> result = UserDao.getAllUsers().stream()
                .filter(user -> user.getId() == task.getId())
                .collect(Collectors.toList());

        result.forEach(user -> user.setStatus(1));
        return result.size();
    }

    static class UserDao {

        private static ArrayList<User> users;

        /**
         * 模拟持久层，从数据库取数据
         */
        private static List<User> getAllUsers() {
            if (null == users) {
                users = new ArrayList<>(60);
                users.add(new User(1, "LiLi", 43, 0));
                users.add(new User(2, "WangYun", 54, 0));
                users.add(new User(3, "LiuSiSi", 89, 0));
                users.add(new User(4, "ZhangJia", 24, 0));
                users.add(new User(5, "ChenXiao", 25, 0));
                users.add(new User(6, "WangHai", 65, 0));
                users.add(new User(7, "FengNian", 45, 0));
                users.add(new User(8, "XiaoXiao", 85, 0));
                users.add(new User(9, "YingMo", 36, 0));
                users.add(new User(10, "KaEr", 98, 0));
                users.add(new User(11, "LiLi2", 43, 0));
                users.add(new User(12, "WangYun2", 54, 0));
                users.add(new User(13, "LiuSiSi2", 89, 0));
                users.add(new User(14, "ZhangJia2", 24, 0));
                users.add(new User(15, "ChenXiao2", 25, 0));
                users.add(new User(16, "WangHai2", 65, 0));
                users.add(new User(17, "FengNian2", 45, 0));
                users.add(new User(18, "XiaoXiao2", 85, 0));
                users.add(new User(19, "YingMo2", 36, 0));
                users.add(new User(20, "KaEr2", 98, 0));
                users.add(new User(21, "LiLi3", 43, 0));
                users.add(new User(22, "WangYun3", 54, 0));
                users.add(new User(23, "LiuSiSi3", 89, 0));
                users.add(new User(24, "ZhangJia3", 24, 0));
                users.add(new User(25, "ChenXiao3", 25, 0));
                users.add(new User(26, "WangHai3", 65, 0));
                users.add(new User(27, "FengNian3", 45, 0));
                users.add(new User(28, "XiaoXiao3", 85, 0));
                users.add(new User(29, "YingMo3", 36, 0));
                users.add(new User(30, "KaEr3", 98, 0));
                users.add(new User(31, "A", 43, 0));
                users.add(new User(32, "B", 54, 0));
                users.add(new User(33, "C", 89, 0));
                users.add(new User(34, "D", 24, 0));
                users.add(new User(35, "E", 25, 0));
                users.add(new User(36, "F", 65, 0));
                users.add(new User(37, "G", 45, 0));
                users.add(new User(38, "H", 85, 0));
                users.add(new User(39, "I", 36, 0));
                users.add(new User(40, "J", 98, 0));
                users.add(new User(41, "K", 43, 0));
                users.add(new User(42, "L", 54, 0));
                users.add(new User(43, "M", 89, 0));
                users.add(new User(44, "N", 24, 0));
                users.add(new User(45, "O", 25, 0));
                users.add(new User(46, "P", 65, 0));
                users.add(new User(47, "Q", 45, 0));
                users.add(new User(48, "R", 85, 0));
                users.add(new User(49, "S", 36, 0));
                users.add(new User(50, "T", 98, 0));
                users.add(new User(51, "U", 43, 0));
                users.add(new User(52, "V", 54, 0));
                users.add(new User(53, "W", 89, 0));
                users.add(new User(54, "X", 24, 0));
                users.add(new User(55, "Y", 25, 0));
                users.add(new User(56, "Z", 65, 0));
                users.add(new User(57, "SunXueFei", 45, 0));
                users.add(new User(58, "WangBin", 85, 0));
                users.add(new User(59, "ZhaoJun", 36, 0));
                users.add(new User(60, "LengXuCheng", 98, 0));
            }
            return users;
        }
    }
}
