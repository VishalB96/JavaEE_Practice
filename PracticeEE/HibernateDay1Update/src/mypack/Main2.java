package mypack;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
public class Main2 
{
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
        Transaction transaction = null; 
        try { 
            transaction = session.beginTransaction(); 
            Product p=new Product();
          //  p.setId(1);
            p.setName("soap");
            p.setQty(75);
            p.setPrice(90);
            session.save(p);      
            transaction.commit(); 
            session.close(); // p has become detached
            session=HibernateUtil.getSessionFactory().openSession();
            System.out.println("before changing qty\t"+p);
            p.setQty(150);
            System.out.println("after changing qty\t"+p);
            Scanner sc=new Scanner(System.in);
            System.out.println(sc.nextInt()); // go and check the database, u wont find changes
            transaction=session.beginTransaction();
            session.update(p);
            p.setPrice(260); // reassociating p with new session
            transaction.commit(); // go and check the database, u will find changes
            session.close();
            
             }
        catch(Exception ee)
        {
        	System.out.println("in catch\t"+ee);
        }
}
}