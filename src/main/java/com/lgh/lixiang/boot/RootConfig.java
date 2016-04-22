package com.lgh.lixiang.boot;

/**
 * Created by Administrator on 2016/4/10.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.luffy.lib.libspring.logging.LoggingConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.File;


@Configuration
//@EnableTransactionManagement(mode = AdviceMode.PROXY)
@ComponentScan({"com.lgh.lixiang.service", "com.lgh.lixiang.nocurrency"})
@EnableJpaRepositories(value = {"com.lgh.lixiang.repository"})
@ImportResource(value = {"classpath:spring-jpa.xml"})
@Import(LoggingConfig.class)
@EnableScheduling
public class RootConfig {

    private static Log log = LogFactory.getLog(RootConfig.class);

    @PostConstruct
    public void init() {
        log.info("root start path " + new File(".").getAbsolutePath());
    }
}
