package kodune_yl;

public class BowlingCalc_tmp {
	
	private int hitCount = 0;
	private int counter = 0;
	private Frame currentFrame;
	private boolean isFinalThrowStikeOrSpare = false;
	private final Frame[] frames = new Frame[12]; 

	public BowlingCalc_tmp(){
		currentFrame = new Frame();
	}
	
	public void hit(int i) throws Exception {
			
		if(hitCount > 20 && !isFinalThrowStikeOrSpare) {
			throw new Exception("Out of throws");
		}
		
		if(hitCount >= 18){ //viimane frame, very very special..yes yes
			lastFrame(i);
			hitCount++;
		}
		else{ //tavaline
			if(i==10){ //kui Strike
				if(!isFirstThrowOfRound()){
					throw new Exception("Teine vise ei saa Strike olla!");
				}
				currentFrame.setWasStrike(true);
				hitCount += 2;
			}
			else if(currentFrame.getFirstThrow() + i == 10){ //kui Spare
				currentFrame.setSecondThrowWasSpare(true);
				hitCount++;
			}
			else{
				if(isFirstThrowOfRound()){ //esimene vise
					currentFrame.setFirstThrow(i);
					hitCount++;
				}
				else{ //teine vise
					currentFrame.setSecondThrow(i);
					hitCount++;
				}
			}
		}
		
		//peale teist viset (kui pole viimane frame) lisab array'sse
		if(hitCount != 0 && isFirstThrowOfRound() && hitCount <= 18){ 
			addFrameToArray();
		}
		
	}
	
	private void addFrameToArray(){
		frames[counter] = currentFrame;
		currentFrame = new Frame();
		counter++;
	}
	
	
	private void lastFrame(int i) throws Exception {		
		switch (hitCount) {
			case 18:  
				if(i == 10){
					isFinalThrowStikeOrSpare = true;
					currentFrame.setWasStrike(true);
					addFrameToArray();
				} 
				else currentFrame.setFirstThrow(i);			
				break;
			case 19:
				if(i == 10 && !frames[counter - 1].isWasStrike()){
					throw new Exception("Siin ei saa Strike tulla!");
				}
				else{
					if(i == 10){
						currentFrame.setWasStrike(true);
						addFrameToArray();
					}
					else if(currentFrame.getFirstThrow() + i == 10){
						isFinalThrowStikeOrSpare = true;
						currentFrame.setSecondThrowWasSpare(true);
						addFrameToArray();
					}
					else if(i != 10 && frames[counter - 1].isWasStrike()){ //kui Strike või Spare ei kordu peale esimest Strike 
						currentFrame.setFirstThrow(i);
					}
					else{ // teine vise ei olnud Spare ega Strike
						currentFrame.setSecondThrow(i);
						currentFrame.setScore(currentFrame.getFirstThrow() + i);
						addFrameToArray();
					}
					break;
				}			
			case 20:
				if(i == 10 && !frames[counter - 1].isWasStrike() && !frames[counter - 2].isWasStrike()){
					throw new Exception("Siin ka ei saa Strike tulla!");
				}
				else{
					if(i == 10 && frames[counter - 1].isWasStrike() && frames[counter - 2].isWasStrike()){
						currentFrame.setWasStrike(true); //viimane ring kõik Strike
						frames[counter - 2].setScore(30);
					}
					else if(i == 10 && frames[counter - 1].isSecondThrowWasSpare()){
						frames[counter - 1].setScore(20);
					}
					else if(currentFrame.getFirstThrow() + i == 10){ //viimane vise ja Spare
						currentFrame.setSecondThrowWasSpare(true);
						frames[counter - 1].setScore(20);
					}
					else if(frames[counter - 1].isSecondThrowWasSpare()){
						currentFrame.setFirstThrow(i);
						frames[counter - 1].setScore(10 + i);
					}
					else {
						currentFrame.setFirstThrow(i);
						frames[counter].setScore(i);
					}
				}
				break;
		}
	}

	private boolean isFirstThrowOfRound(){
		return(hitCount % 2 == 0);
	}
	
	
	public void calculateScoreWithoutLastFrame(){
		for(int i = 0; i < frames.length - 3; i++){
			if(frames[i] != null){
				if(frames[i].isWasStrike()){
					if(frames[i+1].isWasStrike() && frames[i+2].isWasStrike()) //kui järgmised 2 ka Strike
						frames[i].setScore(30);
					else if(frames[i+1].isWasStrike() && !(frames[i+2].isWasStrike())){ //kui järgmine Strike, aga ülejärgmine mitte 
						frames[i].setScore(20 + frames[i+2].getFirstThrow());
					}
					else if(frames[i+1].isSecondThrowWasSpare())
						frames[i].setScore(20);
					else frames[i].setScore(10 + frames[i+1].getFirstThrow() + frames[i+1].getSecondThrow());
				} //END was Strike
				else if(frames[i].isSecondThrowWasSpare()){
					if(frames[i + 1].isWasStrike())
						frames[i].setScore(20);
					else frames[i].setScore(10 + frames[i+1].getFirstThrow());
				} //END was Spare
				else frames[i].setScore(frames[i].getFirstThrow() + frames[i].getSecondThrow());
			}
		}
	}
	
	
	public int getScore(){
		int score = 0;
		calculateScoreWithoutLastFrame();
		for(Frame f : frames)
			if(f != null){
				//System.out.println(f.getScore());
				score += f.getScore(); 
			}
							
		return score;
	}

}