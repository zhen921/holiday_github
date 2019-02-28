package user.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
//	private static SessionFactory sessionFactory;
//	public  HibernateUtil() {
//		// TODO Auto-generated constructor stub
//	}
//	public static SessionFactory getSessionFactory(){
//		if(sessionFactory==null){
//			Configuration conf=new Configuration().configure();
//			sessionFactory=conf.buildSessionFactory();
//			return sessionFactory;
//		}else{
//			return sessionFactory;
//		}
//	}
	private static SessionFactory sf;
	static {
		sf=new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
