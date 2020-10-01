package mypack;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
public class Main1 
{
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null; 
        try { 
            transaction = session.beginTransaction(); 
            Product p=new Product();
            p.setName("soap");
            p.setQty(75);
            p.setPrice(90);
            session.save(p);      
            transaction.commit(); 
            session.close();
            System.out.println("before changing qty\t"+p);
            p.setQty(150); // detached
            System.out.println("after changing qty\t"+p);
            Scanner sc=new Scanner(System.in);
            System.out.println(sc.nextInt()); // go and check the database, u wont find changes
            session=HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.update(p); //reassociate detached entity with a new session
            transaction.commit(); 
            session.close();
           }
        catch(Exception ee)
        {
        	ee.printStackTrace();
        }
}
}