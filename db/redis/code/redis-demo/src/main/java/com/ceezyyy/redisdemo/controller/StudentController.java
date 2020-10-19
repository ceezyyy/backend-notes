package com.ceezyyy.redisdemo.controller;

import com.ceezyyy.redisdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * Delete key-value
     *
     * @param key
     * @return
     */
    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable(value = "key") String key) {
        Boolean isDelete = redisTemplate.delete(key);
        return isDelete;
    }


    /**
     * Store strings
     *
     * @return
     */
    @GetMapping("/strings")
    public String testStrings() {
        redisTemplate.opsForValue().set("Hello", "World");
        String value = (String) redisTemplate.opsForValue().get("Hello");
        return value;
    }

    /**
     * Store hashes
     *
     * @return
     */
    @GetMapping("/hashes")
    public Map<String, String> testHashes() {
        redisTemplate.opsForHash().put("001", "Hello", "World");
        redisTemplate.opsForHash().put("001", "CDC", "3ho");
        Map entries = redisTemplate.opsForHash().entries("001");
        return entries;
    }

    /**
     * Store lists
     *
     * @return
     */
    @GetMapping("/lists")
    public List<String> testLists() {
        redisTemplate.opsForList().rightPush("CDC", "higher brothers");
        redisTemplate.opsForList().rightPush("CDC", "3ho");
        redisTemplate.opsForList().rightPush("CDC", "Ty");
        return redisTemplate.opsForList().range("CDC", 0, -1);
    }


    /**
     * Store sets
     *
     * @return
     */
    @GetMapping("/sets")
    public Set<String> testSets() {
        redisTemplate.opsForSet().add("CDC members", "higher brothers", "higher brothers", "higher brothers");
        Set members = redisTemplate.opsForSet().members("CDC members");
        return members;
    }

    /**
     * Store sorted set
     *
     * @return
     */
    @GetMapping("/zsets")
    public Set<String> testSortedSets() {
        redisTemplate.opsForZSet().add("Higher essentials", "mr enjoy da money", 200);
        redisTemplate.opsForZSet().add("Higher essentials", "prince charming", 100);
        redisTemplate.opsForZSet().add("Higher essentials", "five stars", 300);
        Set higherEssentialsReversed = redisTemplate.opsForZSet().reverseRange("Higher essentials", 0, -1);
        return higherEssentialsReversed;
    }

}
