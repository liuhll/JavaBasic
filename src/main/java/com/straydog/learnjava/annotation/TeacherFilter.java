package com.straydog.learnjava.annotation;

/**
 * Created by jyyc on 2017/5/4.
 */

@Table("teacher")
public class TeacherFilter {

    @Column("id")
    private int id;

    @Column("age")
    private int age;

    @Column("name")
    private String name;

    @Column("teach_course")
    private String teachCourse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeachCourse() {
        return teachCourse;
    }

    public void setTeachCourse(String teachCourse) {
        this.teachCourse = teachCourse;
    }
}
