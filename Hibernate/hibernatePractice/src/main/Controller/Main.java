package main.Controller;

import main.java.Config.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

    }
}
