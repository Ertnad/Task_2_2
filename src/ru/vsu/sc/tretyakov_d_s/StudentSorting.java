package ru.vsu.sc.tretyakov_d_s;

import ru.vsu.sc.tretyakov_d_s.Utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentSorting {

    public List<List<String>> sortStudent (List<List<String>> list) {
        LinkedList<StudentCase> newList = toStudentList(list);
        if (checkCorrectness(newList)) {
            boolean isSorted = false;

            while (!isSorted) {
                isSorted = true;

                for (int i = 0; i < newList.size() - 1; i++) {
                    try {
                        if (newList.get(i).getCourse() > newList.get(i + 1).getCourse()) {
                            isSorted = false;

                            StudentCase temp = newList.get(i + 1);
                            newList.set(newList.get(i), i + 1);
                            newList.set(temp, i);
                        }
                    } catch (LinkedList.LinkedListException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            return null;
        }

        return toListString(newList);
    }

    private LinkedList<StudentCase> toStudentList(List<List<String>> list) {
        LinkedList<StudentCase> newList = new LinkedList<>();

        for (List<String> strings : list) {
            newList.addLast(new StudentCase(strings));
        }

        return newList;
    }

    private List<String> studentsToString(StudentCase students) {
        String str = students.toString();
        return ListUtils.toList(str);
    }

    private List<List<String>> toListString (LinkedList<StudentCase> list) {
        List<List<String>> resultList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            List<String> temp = null;
            try {
                temp = studentsToString(list.get(i));
            } catch (LinkedList.LinkedListException e) {
                e.printStackTrace();
            }
            resultList.add(temp);
        }

        return resultList;
    }

    private boolean checkCorrectness (LinkedList<StudentCase> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i).getCourse();
                if(a >= 7) {
                    return false;
                }
            }
        }catch (LinkedList.LinkedListException e) {
                e.printStackTrace();
        }
        return true;
    }

}
