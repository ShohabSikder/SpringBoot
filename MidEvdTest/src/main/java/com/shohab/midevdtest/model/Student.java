
package com.shohab.midevdtest.model;

/**
 *
 * @author user
 */
public class Student {
    private int sid;
    private String roll;
    private String name;
    private String department;
    private String marks;

    public Student() {
    }

    public Student(int sid, String roll, String name, String department, String marks) {
        this.sid = sid;
        this.roll = roll;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" + "sid=" + sid + ", roll=" + roll + ", name=" + name + ", department=" + department + ", marks=" + marks + '}';
    }
    
}
