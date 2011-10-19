package kodune_yl;

public class BowlingCalc {
	
	private int score = 0;
	private int hitCount = 0;
	
	private boolean wasSpare = false;
//	private boolean afterStrike1 = false;
//	private boolean afterStrike2 = false;
	
	private int counter = 0;
	
	private int lastHit = -1;
	
	public BowlingCalc(){
		System.out.println("sadasd111222333");
	}

	public void hit(int i) throws Exception {
		if(hitCount > 20) {
			throw new Exception("Out of throws");
		}
		

		
		increaseScore(i);
		updateFlags(i);
		System.out.println(i + ": " + score);
		
		if(hitCount >= 18) {	//viimane freim
			hitCount++;
		}
		else if (hitCount % 2 == 0 && i == 10) {	// freimi esimene vise ja plats puhas
			hitCount += 2;
		}
		else {
			hitCount++;
		}
	}

	private void increaseScore(int i) {
		if(wasSpare) {
			if(hitCount == 20) {
				score += i;
			}
			else {
				score += 2 * i; 
			}			
		}
		else if (counter == 1 || counter == 2) {
			if(hitCount == 20) {
				score += i;
			}
			else {
				score += 2 * i;
			}			
		}
		else if (counter == 3) {
			if(hitCount == 20) {
				score += 2 * i;
			}
			else {
				score += 3 * i;
			}			
		}
//		else if (afterStrike2) {
//			score += 3 * i;
//		}
//		else if (afterStrike1) {
//			score += 2 * i;
//		}
		else {
			score += i;
		}		
	}

	private void updateFlags(int i) {
		wasSpare = false;
		
		if(counter > 0)
			counter--;
		
//		if(afterStrike2) {
//			afterStrike2 = false;
//		}
//		else {
//			afterStrike1 = false;
//		}
//		
		if(hitCount % 2 == 1 && lastHit + i == 10) {
			wasSpare = true;
		}
//		else if (i == 10 && hitCount % 2 == 0 && (wasStrike || twoLastWereStrikes) ) {
//			twoLastWereStrikes = true;
//		}
		else if (i == 10 && hitCount % 2 == 0) {
			wasSpare = false;

			if(counter == 2) {
				counter = 3;
			}
			else {
				counter += 2;
			}
			
//			afterStrike1 = true;
//			afterStrike2 = true;
		}
		
		lastHit = i;
	}
	
	public Object getScore() {
		return score;
	}
	
}
