package ru.vsu.sc.tretyakov_d_s.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ListUtils {
  public static List<List<String>> loadStringList2FromFile(String fileName) {
    try {
      return toList2(readLinesFromFile(fileName));
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
    List<String> lines;
    try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
      lines = new ArrayList<>();
      while (scanner.hasNext()) {
        lines.add(scanner.nextLine());
      }
    }
    return lines.toArray(new String[0]);
  }

  public static List<List<String>> toList2(String[] lines) {
    List<List<String>> list2 = new ArrayList<>();
    for (String line : lines) {
      list2.add(toList(line));
    }
    return list2;
  }

  public static List<List<String>> toList2(String[][] lines) {
    List<List<String>> list2 = new ArrayList<>();
    for (String[] line : lines) {
      list2.add(toList(line));
    }
    return list2;
  }

  public static List<String> toList(String str) {
    String[] values = str.split(" ");
    return new ArrayList<>(Arrays.asList(values));
  }

  public static List<String> toList(String[] str) {
    return new ArrayList<>(Arrays.asList(str));
  }

  public static String[] toStringArr(List<String> list) {
    if (list == null) {
      return null;
    }
    String[] result = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  public static String[][] toStringArr2(List<List<String>> list) {
    if (list == null) {
      return null;
    }
    String[][] result = new String[list.size()][];
    for (int i = 0; i < list.size(); i++) {
      result[i] = toStringArr(list.get(i));
    }
    return result;
  }

  public static String toString(List<String> list) {
    StringBuilder str = new StringBuilder();
    for (String s : list) {
      str.append(s).append(" ");
    }
    return str.toString();
  }


  public static void writeList2ToFile(String fileName, List<List<String>> list) {
    try (PrintWriter out = new PrintWriter(fileName)) {
      for (List<String> strings : list) {
        out.println(toString(strings));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
