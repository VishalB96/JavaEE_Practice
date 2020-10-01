package mypack;

import javax.persistence.*;

// Generated Aug 14, 2012 11:51:58 AM by Hibernate Tools 3.2.2.GA

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name="Book")
public class Book  {

	/**
	 * 
	 */
	
	private int id;
	private String name;
	private String subject;
	private int cost;

	public Book() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bkid")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="bname")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="subject")
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Column(name="cost")
	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
