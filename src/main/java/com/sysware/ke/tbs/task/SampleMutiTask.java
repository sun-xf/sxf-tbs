package com.sysware.ke.tbs.task;

import com.sysware.ke.tbs.domain.User;
import com.sysware.ke.tbs.service.UserService;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 批处理数据示例
 */
@Slf4j
@Component
public class SampleMutiTask implements IScheduleTaskDealMulti<User> {

    @Autowired
    private UserService userService;

    @Override
    public List<User> selectTasks(String taskParameter, String ownSign, int taskItemNum,
                                  List<TaskItemDefine> taskItemList, int eachFetchDataNum) {

        List<Integer> taskItemIds = taskItemList.stream()
                .map(TaskItemDefine::getTaskItemId)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<User> users = userService.getUsers(taskItemNum, taskItemIds, eachFetchDataNum);

        /*List<String> taskItemIds = taskItemList.stream()
                .map(TaskItemDefine::getTaskItemId)
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<User> users = userService.getUserList(taskItemNum, taskItemIds, eachFetchDataNum);*/

        log.info("获取到{}条待处理的用户", users.size());
        return users;
    }

    @Override
    public boolean execute(User[] tasks, String ownSign) throws Exception {
        try {
            for (User task : tasks) {

                log.info("开始处理用户：{}", task);
                task.setAge(task.getAge() + 1);
                userService.update(task);
            }
            return true;
        } catch (Exception e) {
            log.error("处理失败：user:{}", tasks);
            return false;
        }
    }

    @Override
    public Comparator<User> getComparator() {
        // 可不实现
        return null;
    }
}
