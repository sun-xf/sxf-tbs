package com.sysware.ke.tbs.frame;

import com.sysware.ke.tbs.task.DbDemoMulti;
import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Sunxuefei
 * @desc
 * @date 2020/9/3 9:57
 **/
@Configuration
@Slf4j
public class WebAppBeanRegister {

    @Autowired
    private DbDemoMulti dbDemoMulti;

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

    @Bean
    public DataSource basicDataSourceFactory() {
        InputStream is = this.getClass().getResourceAsStream("/application.properties");
        Properties properties = new Properties();
        DataSource dataSource;
        try {
            InputStreamReader ir = new InputStreamReader(is,"UTF-8");
            properties.load(ir);

            dataSource = BasicDataSourceFactory.createDataSource(properties);
            dbDemoMulti.setDataSource(dataSource);

            Connection connection = dataSource.getConnection();
            log.info("获取数据库连接:{}",connection.getClass());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dataSource;
    }
}
