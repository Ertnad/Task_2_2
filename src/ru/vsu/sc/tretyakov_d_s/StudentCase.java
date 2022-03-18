package ru.vsu.sc.tretyakov_d_s;

import java.util.List;

public class StudentCase {

    private final String fullName;
    private final int course;

    public StudentCase(List<String> list) {
        this.fullName = list.get(0);
        this.course = Integer.parseInt(list.get(1));
    }

    public int getCourse() {
        return course;
    }

    public String toString() {
        return String.format("%s %s", fullName, course);
    }

}
