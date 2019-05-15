
import entity.UserTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TstUserTable {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OrmExample");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        начинаем чтото делать в бд
        entityManager.getTransaction().begin();


//        добавление
//        UserTable userTable = new UserTable();
//        userTable.setLogin("second");
//
////        чтобы объект можно было добавить в бд выполняем:
//        entityManager.persist(userTable);
//        т.е. передаем туда объект.


//        получение пользователя
        UserTable userFromDb = entityManager.find(UserTable.class, 1);

        System.out.println(userFromDb.getLogin());




//        подтверждаем действие для добавление в бд
        entityManager.getTransaction().commit();

//        откатить - rollback вместо commit



        entityManager.close();
        entityManagerFactory.close();
    }
}
