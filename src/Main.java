import java.util.List;

interface Person{}
class Student implements Person{}
class Teacher implements Person{}
public class Main {
    private static void test(Person person){}
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        test(student);
        test(teacher);
    }
}
