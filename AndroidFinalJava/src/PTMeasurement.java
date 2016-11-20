
public abstract class PTMeasurement {

    private float height;
    private float weight;
    private String comments;
    private float neck;
    private float waist;
    private float bodyfat;
    private String assessment;
    private String date;
    boolean isValid = true;
    public String feedback = "";
    
    public static float CONVERTINCHESTOCM(float num){
    	float cmVal = (float) (num / 2.54);
    	return cmVal;
    }
    public static float CONVERTCMTOINCHES(float num){
    	float cmVal = (float) (num * 2.54);
    	return cmVal;
    }
    
    //Getters and Setters with validation within setter
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		if (height > 24 && height < 120){
			this.height = height;
		}
		else {
			isValid = false;
			feedback += "Must be a valid height!\n";
		}
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		if (weight > 30 && weight < 1500){
			this.weight = weight;
		}
		else{
			isValid = false;
			feedback += "Must be a valid weight!\n";
		}
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public float getNeck() {
		return neck;
	}
	public void setNeck(float neck) {
		if (neck > 10 && neck < 50){
			this.neck = neck;
		}
		else {
			isValid = false;
			feedback += "Must be a valid neck measurement!\n";
		}
	}
	public float getWaist() {
		return waist;
	}
	public void setWaist(float waist) {
		if (waist > 20 && waist < 150){
			this.waist = waist;
		}
		else {
			isValid = false;
			feedback += "Must be a valid waist measurement!\n";
		}
	}
	public float getBodyfat() {
		return bodyfat;
	}
	public void setBodyfat(float bodyfat) {
		this.bodyfat = bodyfat;
	}
	abstract String assessBodyFat();
	
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
    
    
}
