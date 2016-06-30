
public class Bowling {
	int score;
	int[] frameScore;
	int[] bonusCount;
	//int bounsCount = 0;
	private int rollIndex;
	
	public Bowling(){
		frameScore = new int[10];
		bonusCount = new int[10];
		score = 0;
		rollIndex = 0;
	}
	
	public void roll(int pins) {
		addBonus(pins);
		if (allFramesCompleted()) return;
		calcuateFrameScore(pins);
		addTotalScore(pins);
		if (isStrike())	setStrikeBounsCount();
		else if (isSpare())	setSpareBounsCount();
		rollIndex++;
	}

	private void setSpareBounsCount() {
		bonusCount[getFrameIndex()] = 1;
	}

	private void setStrikeBounsCount() {
		bonusCount[getFrameIndex()] = 2;
		rollIndex++;
	}

	private void addTotalScore(int pins) {
		score+=pins;
	}

	private void calcuateFrameScore(int pins) {
		frameScore[getFrameIndex()]+=pins;
	}

	private boolean allFramesCompleted() {
		return getFrameIndex()>=10;
	}

	private boolean isStrike() {
		return (rollIndex%2==0 && frameScore[getFrameIndex()]==10);
	}

	private int getFrameIndex() {
		return rollIndex/2;
	}

	private boolean isSpare() {
		return frameScore[getFrameIndex()] == 10;
	}

	private void addBonus(int pins) {
		for (int i=0;i<10;i++)
			if (bonusCount[i]>0){
				addTotalScore(pins);
				bonusCount[i]--;
			}
	}

	public int getScore() {
		return score;
	}

}

