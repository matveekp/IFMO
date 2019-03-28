package lesson9;

// написать генератор списка объектов класса Person
// Сортировать объекты Person по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании




import java.util.*;

public class Person {
     private String name;
     private int age;
     private int salary;
     private String company;

     public Person(String name, int age, int salary, String company) {
         this.name = name;
         this.age = age;
         this.salary = salary;
         this.company = company;
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

     public int getSalary() {
         return salary;
     }

     public void setSalary(int salary) {
         this.salary = salary;
     }

     public String getCompany() {
         return company;
     }

     public void setCompany(String company) {
         this.company = company;
     }

    @Override
    public String toString() {
        return "Name: " + name  + " Age: " + age + " Salary: "  + salary + " Company: " + company;
    }
}


    class Test {
        public static void main(String[] args) {
            List<Person> list = new ArrayList<>(PersonGenerator.generate(5));


            Comparator<Person> comparator1 = new NameComparator();
            Collections.sort(list, comparator1);

            for (Person person : list) {
                System.out.println(person);
            }

            System.out.println("-----------------------------------------------------------------------------");

            Comparator<Person> comparator2 = new NameComparator().thenComparing(new SalaryComparator());
            Collections.sort(list, comparator2);

            for (Person person : list) {
                System.out.println(person);
            }

            System.out.println("-----------------------------------------------------------------------------");

            Comparator<Person> comparator3 = new NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator()).thenComparing(new CompanyComparator());
            Collections.sort(list, comparator3);

            for (Person person : list) {
                System.out.println(person);
            }

        }
    }



    class NameComparator implements Comparator<Person>{


        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


    class SalaryComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSalary() - o2.getSalary();
        }
    }


    class AgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge() ;
        }
    }


    class CompanyComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getCompany().compareTo(o2.getCompany());
        }
    }






    class PersonGenerator {

        public static String NameGenerator() {
            String name;

            String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
                    "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
                    "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
                    "Mar", "Luk" };
            String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
                    "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
                    "marac", "zoir", "slamar", "salmar", "urak" };
            String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
                    "tron", "med", "ure", "zur", "cred", "mur" };


            Random random = new Random();

            return Beginning[random.nextInt(Beginning.length)]+Middle[random.nextInt(Middle.length)] +End[random.nextInt(End.length)];
        }


        public static String CompanyGenerator() {

            String[] End = { "Mac", "Bill", "Ford", "Sold", "Cruel",
                    "Ray", "Break", "Zed", "Dark", "Mort", "Jag", "Mer", "Jar", "Mjol",
                    "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
                    "Mar", "Luk" };


            String[] Domen = { "ru.", "eu.", "us.", "fr.", "it.", "gr.", "nz."};


            Random random = new Random();

            return Domen[random.nextInt(Domen.length)] + "company" + random.nextInt(100) + "." + End[random.nextInt(End.length)];
        }



        public static List<Person> generate(int num) {
            if (num <= 0) {
                return Collections.emptyList();
            }

            Random random = new Random();
            List<Person> list = new ArrayList<>(num);



            for (int i = 0; i < num; i++) {

                list.add(new Person(NameGenerator(), random.nextInt(100), random.nextInt(1000), CompanyGenerator()));

            }




            return list;
        }




    }




