package kodune_yl;

public class BowlingCalc {
	
	private int score = 0;
	private int hitCount = 0;
	
	private boolean wasSpare = false;
	private boolean wasStrike = false;
	private boolean twoLastWereStrikes = false;
	
	public BowlingCalc(){
		System.out.println("sadasd");
	}

	public void hit(int i) throws Exception {
		if(hitCount > 20) {
			throw new Exception("Out of throws");
		}
		
		if(hitCount >= 19) {	//viimane freim
			hitCount++;
		}
		else if (hitCount % 2 == 0 && i == 10) {	// freimi esimene vise ja plats puhas
			hitCount += 2;
		}
		else {
			hitCount++;
		}
		
		increaseScore(i);
		updateFlags(i);
	}

	private void increaseScore(int i) {
		if(wasSpare) {
			score += 2 * i; 
		}
		else if (twoLastWereStrikes) {
			score += 20 + i;
		}
		else if (wasStrike) {
			score += 10 + i;
		}
		else {
			score += i;
		}		
	}

	private void updateFlags(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public Object getScore() {
		return score;
	}
	
}
