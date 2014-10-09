package jayxigua.LotteryRiskCalculation.soccer.entity;

/**
 * 计算结果
 * 
 * @author jayxigua
 * 
 */
public class CalculateProResult {
	/**
	 * 双方比赛记录 胜负值
	 */
	ExploitsStateValue last6WEsv;
	/**
	 * 双方通过各种比赛情况计算 实力对比值
	 */
	ExploitsStateValue powerEsv;

	public ExploitsStateValue getLast6WEsv() {
		return last6WEsv;
	}

	public void setLast6WEsv(ExploitsStateValue last6wEsv) {
		last6WEsv = last6wEsv;
	}

	public ExploitsStateValue getPowerEsv() {
		return powerEsv;
	}

	public void setPowerEsv(ExploitsStateValue powerEsv) {
		this.powerEsv = powerEsv;
	}

	public String esvCombine() {
		StringBuffer sb = new StringBuffer();
		sb.append("win ").append(last6WEsv.getWin().multiply(powerEsv.getWin()));
		sb.append(",planish ").append(last6WEsv.getPlanish().multiply(powerEsv.getPlanish()));
		sb.append(",lose ").append(last6WEsv.getLose().multiply(powerEsv.getLose()));

		return sb.toString();
	}

	@Override
	public String toString() {
		return "CalculateResult [last6WEsv=" + last6WEsv + ", powerEsv=" + powerEsv + "]";
	}

}
