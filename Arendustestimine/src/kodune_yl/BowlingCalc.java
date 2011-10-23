package kodune_yl;

public class BowlingCalc {
	
	private int score = 0;
	private int hitCount = 0;
	
	private boolean wasSpare = false;
	
	private int counter = 0;
	
	private int lastHit = -1;
	
	public BowlingCalc(){
		
	}

	public void hit(int i) throws Exception {
		if(hitCount > 20) {
			throw new Exception("Out of throws");
		}
		
		increaseScore(i);
		updateFlags(i);
		
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
			if(hitCount == 20) {	//tegemist on viimase frame 3. viskega
				score += i;			//liidame sparele juurde
			}
			else {
				score += 2 * i; 
			}			
		}
		else if (counter == 1 || counter == 2) {
			if(hitCount == 19 && lastHit != 10) {	//kui eelviimane frame visati strike, siis 2x punktid
				score += 2 * i;
			}
			else if (hitCount >= 19) {				//viimase frame 2. ja 3. vise
				score += i;
			}
			else {
				score += 2 * i;
			}			
		}
		else if (counter == 3) {
			if(hitCount == 19) {					//viimase frame eelviimane vise

				score += 2 * i;
			}
			else if (hitCount == 20) {				//viimase frame viimane vise
				score += i;
			}
			else {
				score += 3 * i;
			}			
		}
		else {
			score += i;
		}		
	}

	private void updateFlags(int i) {
		wasSpare = false;
		
		if(counter > 0) {
			counter--;
		}

		if(hitCount % 2 == 1 && lastHit + i == 10) {	//freimi 2. vise ja kahe viske summa on 10
			wasSpare = true;
		}
		else if (i == 10) {		//10 punkti
			wasSpare = false;

			if(lastHit == 10) {	//kui eelmine vise oli strike
				counter = 3;	//3 tähendab, et järgmise viske eest saab 3x punktid
			}
			else {
				counter += 2;	//2 tähendab, et järgmise 2 viske eest saab 2x punktid
			}					//1 tähendab, et järgmise viske eest saab 2x punktid
		}
		
		lastHit = i;
	}
	
	public Object getScore() {
		return score;
	}
	
}
