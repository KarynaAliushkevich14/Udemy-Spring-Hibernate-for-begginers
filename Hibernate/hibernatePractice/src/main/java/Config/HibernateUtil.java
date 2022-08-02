package main.java.Config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    //настройка и работа с сессиями (фабрика сессий)
    private static SessionFactory sessionFactory;

    static {

        //вся библиотека Hibernate состоит из Сервисов (Service).
        //тут запускается стандартный сервис
        final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure() //можем вписать url ссылку где находится hibernate.cfg.xml
                .build();

        //объект standardRegistry передаём в MetadataSources
        //MetadataSources - для работы с метаданными маппинга объектов
        try {
            sessionFactory = new MetadataSources(standardRegistry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(standardRegistry);
        }
    }

    //метод геттер для sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}




