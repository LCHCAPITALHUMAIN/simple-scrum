package com.nazir.customscrum.server;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 11, 2010
 * Time: 12:14:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateImpl {
    public static SessionFactory talkToDb() {
        try {

            SessionFactory sessionFactory = new AnnotationConfiguration().
                    configure(new File("/home/nazir/Dropbox/projects/CustomScrum/CustomScrum/src/com/nazir/customscrum/server/hibernate.cfg.xml")).
                    buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            writeToFile(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static void writeToFile(String message) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("/home/nazir/Dropbox/projects/ESCRUM/log.log"));
            fos.write(message.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
