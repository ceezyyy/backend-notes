package com.ceezyyy.redisdemo.controller;

import com.ceezyyy.redisdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * Set key-value
     *
     * @param student
     * @return
     */
    @PostMapping("/set")
    public String set(@RequestBody Student student) {
        redisTemplate.opsForValue().set("student1", student);
        return "Set succeeded!";
    }

    /**
     * Get value from key
     *
     * @param key
     * @return
     */
    @GetMapping("/get/{key}")
    public Student get(@PathVariable(value = "key") String key) {
        Student student = (Student) redisTemplate.opsForValue().get(key);
        return student;
    }

    /**
     * Delete value from key
     *
     * @param key
     * @return
     */
    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable(value = "key") String key) {
        Boolean isDelete = redisTemplate.delete(key);
        return isDelete;
    }
}
