package lesson13;


import java.lang.reflect.Field;

public class Reflection {



    public static void main(String[] args) throws IllegalAccessException {

        SomeClass someClass = new SomeClass("myClass", 1);
        System.out.println(toString(someClass));
    }

    public static String toString(Object obj) throws IllegalAccessException {
        Class<Object> someCls = (Class<Object>) obj.getClass();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(someCls);
        stringBuilder.append("{");

        Field[] fields = someCls.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            stringBuilder.append(field.getName() + "=");
            stringBuilder.append(field.get(obj));
            stringBuilder.append(", ");
        }

        return stringBuilder.toString().substring(0, stringBuilder.length()-2) + "}";
    }
}


class ParentClass {
    public String parentField;
    public void parentVoid(){
        System.out.println("parent void");
    }
}

class SomeClass extends ParentClass {

    private String name;
    private int version;

    public SomeClass(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public SomeClass() {
    }

    public SomeClass(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private String getInfo(){
        return "private Void";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

   /* public void setVersion(int version) {
        this.version = version;
    }*/

    @Override
    public String toString() {
        return "ConcurrentExample{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
