
public class Bowling {
	private int score;
	private int[] frameScore;
	private int[] bonusCount;
	private int rollIndex;
	
	/**
	 * 创建一次游戏
	 */
	public Bowling(){
		frameScore = new int[10];
		bonusCount = new int[10];
		score = 0;
		rollIndex = 0;
	}
	
	/**
	 * 保龄球投掷一次，pins为玩家击中的瓶子数量
	 * @param pins
	 */
	public void roll(int pins) {
		addBonus(pins);
		if (allFramesCompleted()) return;
		calcuateFrameScore(pins);
		addTotalScore(pins);
		if (isStrike())	setStrikeBounsCount();
		else if (isSpare())	setSpareBounsCount();
		rollIndex++;
	}
	
	/**
	 * 获取当前游戏分数
	 * @return 当前游戏分数
	 */
	public int getScore() {
		return score;
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



}

