package com.pky.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by pky1030 on 16. 2. 28..
 */
@Component
public class TestCommand implements CommandLineRunner {
    @Autowired
    private RedisTemplate<Object , String> template;

    @Override
    public void run(String... args) throws Exception {
        ValueOperations<Object, String> ops = this.template.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.template.hasKey(key)) {
            ops.set(key, "foo");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }
}
