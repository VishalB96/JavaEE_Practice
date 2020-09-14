/**
 * 
 */
package mypack;

/**
 * @author Vishal
 *
 */
public class CareerExpert {

	
	public String getAdvice(String qualification) {
		if(qualification.equalsIgnoreCase("be"))
			return "DAC";
		else if(qualification.equalsIgnoreCase("hsc"))
			return "be";
		else if(qualification.equalsIgnoreCase("ssc"))
			return "HSC";
		
		return "FRELANCE";
	}
}
