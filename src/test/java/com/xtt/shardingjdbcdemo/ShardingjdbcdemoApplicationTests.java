package com.xtt.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xtt.shardingjdbcdemo.entity.Course;
import com.xtt.shardingjdbcdemo.entity.Dict;
import com.xtt.shardingjdbcdemo.entity.User;
import com.xtt.shardingjdbcdemo.mapper.CourseMapper;
import com.xtt.shardingjdbcdemo.mapper.DictMapper;
import com.xtt.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired(required = false)
    private CourseMapper mapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private DictMapper dictMapper;

    @Test
    void addCourse() {
        for (int i = 0; i < 10; i++) {
            Course course1 = new Course();
            course1.setCname("java" + i);
            course1.setUserId(Long.valueOf(i));
            course1.setCstatus(true);
            mapper.insert(course1);
        }
    }

    @Test
    void queryCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 1366663720594980865L);
        Course course = mapper.selectOne(wrapper);
        System.out.println(course.toString());
    }

    @Test
    void queryCourseAll() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 5L);
        wrapper.eq("cid", 1366663720594980865L);
        Course course = mapper.selectOne(wrapper);
        System.out.println(course.toString());
    }

    @Test
    void updateCourse() {
        UpdateWrapper<Course> wrapper = new UpdateWrapper<>();
        wrapper.set("cstatus", false).set("cname", "java").eq("cid", 1366663720594980865L);
        mapper.update(null, wrapper);

//        Course course = new Course();
//        course.setCid(573528476775088128L);
//        course.setCname("java1");
//        mapper.updateById(course);
    }

    //*********垂直分库**********

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("lucy");
        user.setUstatus(false);
        userMapper.insert(user);
    }

    @Test
    void queryUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 573558316966346753L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user.toString());
    }

    //*********垂直分表**********
    @Test
    void addDict() {
        Dict dict = new Dict();
        dict.setUstatus("0");
        dict.setUvalue("已启用");
        dictMapper.insert(dict);
    }

    @Test
    void delDict() {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dictid", 573563831029071873L);
        dictMapper.delete(queryWrapper);
    }
}
