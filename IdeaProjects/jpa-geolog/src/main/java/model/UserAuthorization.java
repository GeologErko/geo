package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserAuthorization {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Авторизация" +
                "\n" + "Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();




        List<User> users = entityManager.createQuery("select u from User u where u.login= :login and " +
                        "u.password= :password",User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();

        for (User user: users){
            if((user.getLogin().equals(login)) && (user.getPassword().equals(password))){
                if(user.getReviews() == null) {
                }
                System.out.println("Рол: " + user.getRole());
                System.out.println("Количество заказов: " + user.getOrders());
                System.out.println("Количество отзывов: " + user.getReviews().size());
                System.out.println("Дата регистрации: " + user.getCreatedAt());
//                System.out.println( user.getLogin() +
//                                    user.getPassword() +
//                                    user.getRole()+
//                                    user.getOrders() +
//                                    user.getReviews() +
//                                    user.getCreatedAt());
            }
            else {
                System.out.println("Не правильный логин или пароль.");
            }
        }
    }
}

