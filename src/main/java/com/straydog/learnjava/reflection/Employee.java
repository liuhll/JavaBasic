package com.straydog.learnjava.reflection;

/**
 * Created by jyyc on 2017/5/5.
 */
public class Employee {

    private String name;

    private int age;

    private String phone;

    private int hireAge;

    private String department;

    public Employee(){

    }

    public Employee(String name,int age,String department){
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getHireAge() {
        return hireAge;
    }

    public void setHireAge(int hireAge) {
        this.hireAge = hireAge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void work(){
        System.out.println("员工:" + name + "在工作");
    }

    public void speak(String sayline){
        System.out.println("发言：" + sayline);
    }

    @Override
    public String toString() {
        String eInfo = "员工姓名:%s,年龄:%d,所在部门:%s";
        if (name == null || name.isEmpty()){
            name = "未知";
        }
        if (department == null || department.isEmpty()){
            department = "未知";
        }

        return String.format(eInfo,name,age,department);
    }
}


