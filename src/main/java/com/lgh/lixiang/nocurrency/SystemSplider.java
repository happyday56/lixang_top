package com.lgh.lixiang.nocurrency;

import com.lgh.lixiang.service.BlogService;
import com.lgh.lixiang.service.SpliderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 系统定时抓取任务
 * Created by lenovo on 2015/7/11.
 */

@Service
public class SystemSplider {

    private Log logger = LogFactory.getLog(SystemSplider.class);

    @Autowired
    private SpliderService spliderService;

    @Autowired
    private BlogService blogService;

    @Scheduled(cron = "0 0 13 * * ?")
    private void goSplider() throws Exception {
        logger.info("start splidering now");
        spliderService.start();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    private void countHot() throws Exception {
        logger.info("start counting hot now");
        blogService.countHot();
    }
}
