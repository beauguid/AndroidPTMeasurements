
public class FemaleMeasurement extends PTMeasurement {

	//Only measurements for females take hip circumference into account
	private float hips;
	
	FemaleMeasurement() {
		
	}
	
	FemaleMeasurement(float weight, float height, float waist, float neck, float hips, String comments, String date) {
		this.setWeight(weight);
		this.setHeight(height);
		this.setWaist(waist);
		this.setNeck(neck);
		this.setComments(comments);
		this.setDate(date);
		this.setHips(hips);
		//sets the bodyFat immediately
		if (this.isValid() == true){
			this.setBodyfat(femaleBodyFatPercentage(this.getHeight(),this.getWaist(), this.getNeck(), this.getHips()));
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
	public float femaleBodyFatPercentage(float height, float waist, float neck, float hips)
    {
		float totalBodyFat = -1;
		try {
		double doubWhn = (double) waist + hips - neck;
		double doubHeight = (double) height;
        totalBodyFat = (float) ( 163.205 * Math.log10(doubWhn) - 97.684 * Math.log10(doubHeight) - 78.387 );
        Math.round(totalBodyFat);
        }
        catch (Exception e){
        	feedback += e.toString() + "\n";
        }
        finally {
        	return totalBodyFat;
        }
    }
	
	//Bodyfat assessments for females differ from the ones for males
	String assessBodyFat() {
		String strAssessment = "No assessment";
		float bodyFat = this.getBodyfat();
		if (bodyFat < 13)
        {
			strAssessment = "Essential Fat";
        }
        else if (bodyFat > 14 && bodyFat < 20)
        {
        	strAssessment = "Typical Athlete";
        }
        else if (bodyFat > 20 && bodyFat < 24)
        {
        	strAssessment = "Physically Fit";
        }
        else if (bodyFat > 24 && bodyFat < 31)
        {
        	strAssessment = "Acceptable";
        }
        else
        {
        	strAssessment = "Obese";
        }
		return strAssessment;
	}
	

	public float getHips() {
		return hips;
	}

	public void setHips(float hips) {
		this.hips = hips;
	}
	
	
	
	
}
