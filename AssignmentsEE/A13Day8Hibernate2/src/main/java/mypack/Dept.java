package mypack;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Dept generated by hbm2java
 */
@Entity
public class Dept implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String dname;
	private String loc;

	public Dept() {
	}

	public Dept(int deptno) {
		this.deptno = deptno;
	}

	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	@Id
	public int getDeptno() {
		return this.deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}