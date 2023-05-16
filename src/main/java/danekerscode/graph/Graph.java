package danekerscode.graph;

import java.util.*;

public class Graph<T> {

    private final Boolean bidirectional;
    private final Map<T, List<T>> map;

    public Graph(Boolean bidirectional) {
        this.bidirectional = bidirectional;
        this.map = new HashMap<>();
    }

    public void addVertex(T s) {
        map.put(s, new ArrayList<>());
    }

    public void addEdge(T source, T destination) {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);

        if (bidirectional)
            map.get(destination).add(source);
    }

    public boolean removeVertex(T src) {
        this.map.remove(src);
        new ArrayList<>(map.values()).forEach(t -> t.removeIf(el -> el.equals(src)));
        return true;
    }

    public boolean removeEdge(T src, T dest) {
        if (!map.containsKey(src)) {
            return false;
        }
        if (!map.get(src).contains(dest)) {
            return false;
        }
        map.get(src).remove(src);
        if (bidirectional) {
            map.get(dest).remove(src);
        }
        return true;
    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public Map<T, List<T>> getMap() {
        return map;
    }

    public int getEdgesCount() {
        int count = map.keySet().stream().mapToInt(el -> map.get(el).size()).sum();
        return bidirectional ? count / 2 : count;
    }

    public Boolean hasVertex(T s) {
        return map.containsKey(s);
    }

    public Boolean hasEdge(T s, T d) {
        return map.get(s).contains(d);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.toString()).append(": ");

            for (T w : map.get(v))
                builder.append(w.toString()).append(" ");

            builder.append("\n");
        }
        return builder.toString();
    }
}

class Main {

    static Integer STUDENT_ID_COUNT = 0;

    public static void main(String[] args) {
        Graph<Student> students = new Graph<>(Boolean.TRUE);

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 25; i++)
            studentList.add(create());

        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int n = studentList.size();
            students.addEdge(studentList.get(r.nextInt(n)), studentList.get(r.nextInt(n)));
        }


        System.out.println("Graph:\n" + students);

        System.out.println(students.getVertexCount());
        System.out.println(students.getEdgesCount());


        System.out.println("----------------------------------------");
        System.out.println("this map contains first student " + students.hasVertex(studentList.get(0)));
        System.out.println("student vertices " + students.getMap().get(studentList.get(0)).size());
        System.out.println("student removed:" + students.removeVertex(studentList.get(0)));
        System.out.println("------------------------------------------");
        System.out.println(students.getVertexCount());
        System.out.println(students.hasVertex(studentList.get(0)));
        System.out.println(students.getEdgesCount());
        System.out.println("--------------------------------------------");
        System.out.println(students.getEdgesCount());

        System.out.println(students.hasEdge(studentList.get(1), studentList.get(2)));
        System.out.println(students.removeEdge(studentList.get(1), studentList.get(2)));
        System.out.println(students.getEdgesCount());

    }

    public static Student create() {
        return new Student(++STUDENT_ID_COUNT, UUID.randomUUID().toString().substring(0, 6));
    }

}

record Student(Integer id, String name) {
}
