package reflectdemo1;


import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) {
        Class studentClass = Student.class;
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }


    }
}




