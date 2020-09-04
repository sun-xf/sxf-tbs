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
        return UserDao.getAllUsers().stream()
                .filter(user -> taskIdList.contains(user.getId() % mod) && user.getStatus() == 0)
                .limit(topNum)
                .collect(Collectors.toList());
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
                users = new ArrayList<>(10);
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

                /*users.add(new User("c54c8ab16131469b8362ce70a52a626f", "LiLi", 1, 0));
                users.add(new User("6137679865fc4f45a63c7d14dae2bbcd", "WangYun", 2, 0));
                users.add(new User("b794a7d8b105420cbb80aacf18dec7fd", "LiuSiSi", 3, 0));
                users.add(new User("d38290bf96734955b0e51696da80739b", "ZhangJia", 4, 0));
                users.add(new User("ff1648f08739460a83a798b008a9e36d", "ChenXiao", 5, 0));
                users.add(new User("f04aa89f79b049ffa7399e646bd6e974", "WangHai", 6, 0));
                users.add(new User("62a29162b732400ebacdd24e843ac99c", "FengNian", 7, 0));
                users.add(new User("2fcc25a437aa4dd0b035068c771a840b", "XiaoXiao", 8, 0));
                users.add(new User("f707409a65ff47b585c82e0692ea0f60", "YingMo", 9, 0));
                users.add(new User("34c3ecd25c7945d190005b6736156257", "KaEr", 10, 0));*/
            }
            return users;
        }
    }
}
