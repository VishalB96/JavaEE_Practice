package mypack;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.*;
public class Main 
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
           
            Scanner sc=new Scanner(System.in);
            System.out.println(sc.nextInt()); // go and change the row
// e.g
// 
//mysql> update product set price=200 where id=1;
            System.out.println("Before refresh\t"+p);
            session.refresh(p);
            System.out.println("After refresh\t"+p);
            
             }
        catch(Exception ee)
        {
        	System.out.println("in catch\t"+ee);
        }
}





}