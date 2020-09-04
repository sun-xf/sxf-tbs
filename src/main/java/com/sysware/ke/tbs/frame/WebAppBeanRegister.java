package com.sysware.ke.tbs.frame;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sunxuefei
 * @desc
 * @date 2020/9/3 9:57
 **/
@Configuration
public class WebAppBeanRegister {

    @Bean(initMethod = "init")
    public TBScheduleManagerFactory tbScheduleManagerFactory(
            @Value("${schedule.zookeeper.address}") String zkConnectString,
            @Value("${schedule.root.catalog}") String rootPath,
            @Value("${schedule.timeout}") String zkSessionTimeout,
            @Value("${schedule.username}") String userName,
            @Value("${schedule.password}") String password,
            @Value("${schedule.isCheckParentPath}") String isCheckParentPath) {
        TBScheduleManagerFactory tbScheduleManagerFactory = new TBScheduleManagerFactory();
        Map<String, String> zkConfig = new HashMap<>();
        zkConfig.put("zkConnectString", zkConnectString);
        zkConfig.put("rootPath", rootPath);
        zkConfig.put("zkSessionTimeout", zkSessionTimeout);
        zkConfig.put("userName", userName);
        zkConfig.put("password", password);
        zkConfig.put("isCheckParentPath", isCheckParentPath);
        tbScheduleManagerFactory.setZkConfig(zkConfig);
        return tbScheduleManagerFactory;
    }
}
