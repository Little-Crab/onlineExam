package com.crab.utils;

import com.crab.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Little_Crab
 * @date 2021/4/18 13:17
 */
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private ExamService examService;

    @Scheduled(cron = "30 10 1 20 * ?")
    public void state() {
        examService.updateState();
    }
}
