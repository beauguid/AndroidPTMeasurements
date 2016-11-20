
public class MaleMeasurement extends PTMeasurement {
	MaleMeasurement(){
		
	}
	
	MaleMeasurement(float weight, float height, float waist, float neck, String comments, String date) {
		
		this.setWeight(weight);
		this.setHeight(height);
		this.setWaist(waist);
		this.setNeck(neck);
		this.setComments(comments);
		this.setDate(date);
		//sets the bodyFat immediately
		if (this.isValid() == true){
			this.setBodyfat(maleBodyFatPercentage(this.getHeight(),this.getWaist(), this.getNeck()));
		}
		else {
			feedback += "Error calculating body fat %!\n";
		}
		this.setAssessment(assessBodyFat());
	}
	//Hodgdon-Beckett formula for body fat percentage
	//this calculates the bodyfat percentage
	//since it takes in a different number of parameters, an abstract method was not used
	//male and female measurement classes have their own methods
	@SuppressWarnings("finally")
	public float maleBodyFatPercentage(float height, float waist, float neck)
    {
		float totalBodyFat = -1;
		try {
		float wn = waist - neck;
        double doubWn = (double) wn;
        double doubHeight = (double) height;
        totalBodyFat = (float)( 86.010 * Math.log10(doubWn) - 70.041 * Math.log10(doubHeight) + 36.76 );
        Math.round(totalBodyFat);
        }
        catch (Exception e){
        	feedback += e.toString() + "\n";
        }
        finally {
        	return totalBodyFat;
        }
    }
	
	String assessBodyFat() {
		String strAssessment = "No assessment";
		float bodyFat = this.getBodyfat();
		if (bodyFat < 5)
        {
			strAssessment = "Essential Fat";
        }
        else if (bodyFat > 5 && bodyFat < 14)
        {
        	strAssessment = "Typical Athlete";
        }
        else if (bodyFat > 14 && bodyFat < 17)
        {
        	strAssessment = "Physically Fit";
        }
        else if (bodyFat > 17 && bodyFat < 24)
        {
        	strAssessment = "Acceptable";
        }
        else
        {
        	strAssessment = "Obsese";
        }
		return strAssessment;
	}
}
