package com.eureka.customer.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import tech.powerjob.worker.core.processor.ProcessResult;
import tech.powerjob.worker.core.processor.TaskContext;
import tech.powerjob.worker.core.processor.sdk.BasicProcessor;

@Slf4j
@Component
public class PowerJobTest implements BasicProcessor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ProcessResult process(TaskContext context) throws Exception {
        log.info("PowerJobTest任务开始 ==========>");
        jdbcTemplate.execute("select count(1) ");
        log.info("PowerJobTest任务完成 ==========>");
        return new ProcessResult(true, "Success!");
    }


}
