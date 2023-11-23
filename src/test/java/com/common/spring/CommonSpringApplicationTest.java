package com.common.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b><code>CommonSpringApplicationTest</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2023/11/1 0:04
 *
 * @author yang xiong
 * @since CommonSpring 1.0
 */
@Slf4j
@SpringBootApplication
public class CommonSpringApplicationTest {
    public static void main(String[] args) {
        log.info("启动");
        SpringApplication.run(CommonSpringApplicationTest.class, args);

    }
}
