package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      User user1 = new User("User5", "Lastname5", "user5@mail.ru");
      User user2 = new User("User6", "Lastname6", "user6@mail.ru");
      User user3 = new User("User7", "Lastname7", "user7@mail.ru");
      User user4 = new User("User8", "Lastname8", "user8@mail.ru");

      Car car1 = new Car("BMV", 1);
      Car car2 = new Car("Mercedes", 2);
      Car car3 = new Car("Toyota", 3);
      Car car4 = new Car("KIA", 4);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+ user.getCar());
         System.out.println(" ");
      }

      System.out.println(userService.getUserCar("BMV",1));


      context.close();
   }
}
