package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Регистрация " +
                "\n" + "Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(UserRole.USER);
        user.setCreatedAt(LocalDateTime.now());

        System.out.println(user);

        try {
            entityManager.getTransaction().begin(); // открытие транзакции
            entityManager.persist(user);
//            System.out.println(category.getId() + ". " + category.getName());

            entityManager.getTransaction().commit(); // закрытие транзакции
        } catch (Exception e) {
            entityManager.getTransaction().rollback(); // откат изменении
            System.out.println(e.getMessage());
        }
    }


}
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id категории");
        String categoryId = scanner.nextLine();
        int number = Integer.parseInt(categoryId);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        List<Product> products = entityManager.createQuery("from Product p", Product.class)
                .getResultList();

        double sum = 0;
        for (Product product: products){
            sum = product.getPrice() + sum;
            System.out.println("Продукт: " + product.getName() +
                    ", Цена: " + product.getPrice() +
                    ", Категория: " + product.getCategory().getName());
        }
        System.out.println("Общая сумма: " + sum);


         */


//        List<Category> categories = entityManager.createQuery("select distinct c from Category c join fetch c.products", Category.class)
//                        .getResultList();


// Проходим по каждой категории
//        for (Category category : categories) {
//            // Выводим информацию о категории
//            System.out.println(category.getId() + category.getName());

            // Выводим все продукты этой категории
//            if (category.getProducts() != null || !category.getProducts().isEmpty()) {
//                for (Product product : category.getProducts()) {
//                    System.out.println(category.getId() + category.getName() +
//                            " - " + product.getName());
//                }
//            } else {
//                System.out.println("  Нет продуктов в этой категории.");
//            }
//        }

//        System.out.println(entityManager.isOpen());

        // JPA (Jakarta Persistence API)

        // ORM (Object Relational Mapping)


        // Получить все объекты

//        TypedQuery <Category> query = entityManager.createQuery("select c from Category c", Category.class);
//        List <Category> categories = query.getResultList();
//        for(Category category : categories) {
//            System.out.println(category.getId() + ". " + category.getName());
//        }



//         Подготовенные запросы
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите название категории");
//        String categoryName = scanner.nextLine();

//        TypedQuery<Category> query = entityManager.createQuery("select c from Category c where c.name= :name", Category.class);
//        query.setParameter("name", categoryName);
//
//        Category category = query.getSingleResult();
//        System.out.println(category);


        // Создание объекта (insert)
//        Category category = new Category();
//        category.setName(categoryName);
//
//        try {
//            entityManager.getTransaction().begin(); // открытие транзакции
//
//            entityManager.persist(category);
//            System.out.println(category.getId() + ". " + category.getName());
//
//            entityManager.getTransaction().commit(); // закрытие транзакции
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback(); // откат изменении
//            System.out.println(e.getMessage());
//        }



//          Обновление объекта

//        Category category = entityManager.find(Category.class, 4);
//        category.setName("UPDATE_ТЕСТОВЫЙ");
//        try {
//            entityManager.getTransaction().begin(); // открытие транзакции
//
//            entityManager.merge(category);
//            System.out.println("Категория с таким именем уже существует \n Введите новое название категории [" + categoryName + "]" );
//
//            System.out.println("Введите идентификатор категории:");
//            String categoryNumber = scanner.nextLine();
//
//
//
//            System.out.println(category.getId() + ". " + category);
//
//            entityManager.getTransaction().commit(); // закрытие транзакции
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback(); // откат изменении

//            System.out.println(e.getMessage());
//        }

//    }
//}
