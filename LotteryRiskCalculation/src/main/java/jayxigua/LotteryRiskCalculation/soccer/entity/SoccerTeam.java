package jayxigua.LotteryRiskCalculation.soccer.entity;

/**
 * 球队信息
 * 
 * @author jayxigua
 * 
 */
public class SoccerTeam {

	private String name;

	private int ligaLevel;

	private ExploitsElement last10Exploits;

	private ExploitsElement last10homeVisitingExploits;

	public SoccerTeam(String name, int ligaLevel, String last10Exploits,
			String last10homeVisitingExploits) {
		super();
		this.name = name;
		this.ligaLevel = ligaLevel;
		this.last10Exploits = new ExploitsElement(last10Exploits);
		this.last10homeVisitingExploits = new ExploitsElement(
				last10homeVisitingExploits);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLigaLevel() {
		return ligaLevel;
	}

	public void setLigaLevel(int ligaLevel) {
		this.ligaLevel = ligaLevel;
	}

	public ExploitsElement getLast10Exploits() {
		return last10Exploits;
	}

	public void setLast10Exploits(ExploitsElement last10Exploits) {
		this.last10Exploits = last10Exploits;
	}

	public ExploitsElement getLast10homeVisitingExploits() {
		return last10homeVisitingExploits;
	}

	public void setLast10homeVisitingExploits(
			ExploitsElement last10homeVisitingExploits) {
		this.last10homeVisitingExploits = last10homeVisitingExploits;
	}

	@Override
	public String toString() {
		return "SoccerTeam [name=" + name + ", ligaLevel=" + ligaLevel
				+ ", last10Exploits=" + last10Exploits
				+ ", last10homeVisitingExploits=" + last10homeVisitingExploits
				+ "]";
	}

}
