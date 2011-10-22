package kodune_yl;

public class Frame {
	private int firstThrow;
	private int secondThrow;
	private boolean secondThrowWasSpare = false;
	private boolean wasStrike = false;
	private int score = 0;
	
	
	public int getFirstThrow() {
		return firstThrow;
	}
	public void setFirstThrow(int firstThrow) {
		this.firstThrow = firstThrow;
	}
	public int getSecondThrow() {
		return secondThrow;
	}
	public void setSecondThrow(int secondThrow) {
		this.secondThrow = secondThrow;
	}
	public boolean isSecondThrowWasSpare() {
		return secondThrowWasSpare;
	}
	public void setSecondThrowWasSpare(boolean secondThrowWasSpare) {
		this.secondThrowWasSpare = secondThrowWasSpare;
	}
	public boolean isWasStrike() {
		return wasStrike;
	}
	public void setWasStrike(boolean wasStrike) {
		this.wasStrike = wasStrike;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
