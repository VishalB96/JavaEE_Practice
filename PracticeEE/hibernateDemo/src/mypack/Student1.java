package mypack;
// Generated Sep 15, 2020 9:55:32 PM by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student1 generated by hbm2java
 */
@Entity
@Table(name = "student1", catalog = "mydb")
public class Student1 implements java.io.Serializable {

	private Integer rollno;
	private String address;
	private int age;
	private String name;

	public Student1() {
	}

	public Student1(int age) {
		this.age = age;
	}

	public Student1(String address, int age, String name) {
		this.address = address;
		this.age = age;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "rollno", unique = true, nullable = false)
	public Integer getRollno() {
		return this.rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}