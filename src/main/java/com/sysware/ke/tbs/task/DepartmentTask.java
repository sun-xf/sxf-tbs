package com.sysware.ke.tbs.task;

import com.sysware.ke.tbs.domain.Department;
import com.sysware.ke.tbs.service.DepartmentService;
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
public class DepartmentTask implements IScheduleTaskDealMulti<Department> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<Department> selectTasks(String taskParameter, String ownSign, int taskItemNum,
                                  List<TaskItemDefine> taskItemList, int eachFetchDataNum) {

        List<String> taskItemIds = taskItemList.stream()
                .map(TaskItemDefine::getTaskItemId)
                .map(String::valueOf)
                .collect(Collectors.toList());
        List<Department> departments = departmentService.getDepartmentList(taskItemNum, taskItemIds, eachFetchDataNum);

        log.info("获取到{}条待处理的部门", departments.size());
        return departments;
    }

    @Override
    public boolean execute(Department[] tasks, String ownSign) throws Exception {
        try {
            for (Department task : tasks) {

                log.info("开始处理部门：{}", task);
                task.setTotalNumber(task.getTotalNumber() + 1);
                departmentService.update(task);

            }
            return true;
        } catch (Exception e) {
            log.error("处理失败：user:{}", tasks);
            return false;
        }
    }

    @Override
    public Comparator<Department> getComparator() {
        // 可不实现
        return null;
    }
}
