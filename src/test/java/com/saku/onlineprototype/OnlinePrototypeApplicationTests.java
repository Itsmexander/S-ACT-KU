//package com.saku.onlineprototype;
//
//import com.saku.onlineprototype.component.ClientInitializer;
//import com.saku.onlineprototype.config.AppConfig;
//import com.saku.onlineprototype.entity.User;
//import com.saku.onlineprototype.repository.UserRepository;
//import jakarta.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.Optional;
//
//@SpringBootTest
//class OnlinePrototypeApplicationTests {
//    @Test
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        ClientInitializer clientInitializer = context.getBean(ClientInitializer.class);
//        clientInitializer.run();
//        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
//        emf.close();
//    }
//}
