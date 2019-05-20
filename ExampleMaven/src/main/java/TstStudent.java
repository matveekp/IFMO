import entity.Group;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TstStudent {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = managerFactory.createEntityManager();



//
//        Student student1 = new Student();
//        student1.setName("Bob");
//
//        Student student2 = new Student();
//        student2.setName("Jack");
//
//        Group group1 = new Group();
//        group1.setGroupName("Group1");
//
//        Group group2 = new Group();
//        group2.setGroupName("Group2");
//
//        // добавляем студентов в группы
//
//        student1.getGroups().add(group1);
//        student1.getGroups().add(group2);
//
//        student2.getGroups().add(group1);
//
//        // добавляем группы студентам
//
//        group1.getStudents().add(student1);
//        group1.getStudents().add(student2);
//
//        group2.getStudents().add(student1);
//
//
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(student1);
//        entityManager.persist(student2);
//
//        entityManager.getTransaction().commit();
//

        List<Student> students = entityManager.find(Group.class, 952).getStudents();

        System.out.println("Студенты группы с id = 952");
        for (Student student : students) {
            System.out.println(student.getName());
        }


        List<Group> groups = entityManager.find(Student.class, 951).getGroups();

        System.out.println("Все группы студенты № 951");
        for (Group group : groups) {
            System.out.println(group.getGroupName());
        }




        entityManager.close();
        managerFactory.close();



    }
}
