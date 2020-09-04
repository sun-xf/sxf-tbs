package com.sysware.ke.tbs.service.impl;

import com.sysware.ke.tbs.domain.Department;
import com.sysware.ke.tbs.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public List<Department> getDepartmentList(int mod, List<String> departmentNameList, int topNum) {
        return DepartmentDao.getAllDepartments().stream()
                .filter(department -> departmentNameList.contains(department.getName().substring(0,1)) && department.getStatus() == 0)
                .limit(topNum)
                .collect(Collectors.toList());
    }

    @Override
    public int update(Department task) {
        List<Department> result = DepartmentDao.getAllDepartments().stream()
                .filter(department -> department.getId() == task.getId())
                .collect(Collectors.toList());

        result.forEach(department -> department.setStatus(1));
        return result.size();
    }

    static class DepartmentDao {

        private static ArrayList<Department> departments;

        /**
         * 模拟持久层，从数据库取数据
         */
        private static List<Department> getAllDepartments() {
            if (null == departments) {
                departments = new ArrayList<>(10);
                departments.add(new Department(1, "LiLi", 43, 0));
                departments.add(new Department(2, "WangYun", 54, 0));
                departments.add(new Department(3, "LiuSiSi", 89, 0));
                departments.add(new Department(4, "ZhangJia", 24, 0));
                departments.add(new Department(5, "ChenXiao", 25, 0));
                departments.add(new Department(6, "WangHai", 65, 0));
                departments.add(new Department(7, "FengNian", 45, 0));
                departments.add(new Department(8, "XiaoXiao", 85, 0));
                departments.add(new Department(9, "YingMo", 36, 0));
                departments.add(new Department(10, "KaEr", 98, 0));
                departments.add(new Department(11, "LiLi2", 43, 0));
                departments.add(new Department(12, "WangYun2", 54, 0));
                departments.add(new Department(13, "LiuSiSi2", 89, 0));
                departments.add(new Department(14, "ZhangJia2", 24, 0));
                departments.add(new Department(15, "ChenXiao2", 25, 0));
                departments.add(new Department(16, "WangHai2", 65, 0));
                departments.add(new Department(17, "FengNian2", 45, 0));
                departments.add(new Department(18, "XiaoXiao2", 85, 0));
                departments.add(new Department(19, "YingMo2", 36, 0));
                departments.add(new Department(20, "KaEr2", 98, 0));
                departments.add(new Department(21, "LiLi3", 43, 0));
                departments.add(new Department(22, "WangYun3", 54, 0));
                departments.add(new Department(23, "LiuSiSi3", 89, 0));
                departments.add(new Department(24, "ZhangJia3", 24, 0));
                departments.add(new Department(25, "ChenXiao3", 25, 0));
                departments.add(new Department(26, "WangHai3", 65, 0));
                departments.add(new Department(27, "FengNian3", 45, 0));
                departments.add(new Department(28, "XiaoXiao3", 85, 0));
                departments.add(new Department(29, "YingMo3", 36, 0));
                departments.add(new Department(30, "KaEr3", 98, 0));
                departments.add(new Department(31, "A", 43, 0));
                departments.add(new Department(32, "B", 54, 0));
                departments.add(new Department(33, "C", 89, 0));
                departments.add(new Department(34, "D", 24, 0));
                departments.add(new Department(35, "E", 25, 0));
                departments.add(new Department(36, "F", 65, 0));
                departments.add(new Department(37, "G", 45, 0));
                departments.add(new Department(38, "H", 85, 0));
                departments.add(new Department(39, "I", 36, 0));
                departments.add(new Department(40, "J", 98, 0));
                departments.add(new Department(41, "K", 43, 0));
                departments.add(new Department(42, "L", 54, 0));
                departments.add(new Department(43, "M", 89, 0));
                departments.add(new Department(44, "N", 24, 0));
                departments.add(new Department(45, "O", 25, 0));
                departments.add(new Department(46, "P", 65, 0));
                departments.add(new Department(47, "Q", 45, 0));
                departments.add(new Department(48, "R", 85, 0));
                departments.add(new Department(49, "S", 36, 0));
                departments.add(new Department(50, "T", 98, 0));
                departments.add(new Department(51, "U", 43, 0));
                departments.add(new Department(52, "V", 54, 0));
                departments.add(new Department(53, "W", 89, 0));
                departments.add(new Department(54, "X", 24, 0));
                departments.add(new Department(55, "Y", 25, 0));
                departments.add(new Department(56, "Z", 65, 0));
                departments.add(new Department(57, "SunXueFei", 45, 0));
                departments.add(new Department(58, "WangBin", 85, 0));
                departments.add(new Department(59, "ZhaoJun", 36, 0));
                departments.add(new Department(60, "LengXuCheng", 98, 0));
            }
            return departments;
        }
    }
}
