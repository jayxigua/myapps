package jayxigua.LotteryRiskCalculation.nba.calculate.test.history;

import jayxigua.LotteryRiskCalculation.nba.calculate.EstimateRun;
import jayxigua.LotteryRiskCalculation.nba.entity.NbaCompetition;

import org.junit.Test;

public class EarningsEstimateTest131219 {

	@Test
	public void runEnv() {

	}

	@Test
	public void calculate() {
		System.out.println(EstimateRun.run(createCompetition1()));
	}

	NbaCompetition createCompetition1() {
		NbaCompetition competition = new NbaCompetition("湖人", 1.5, "灰熊", 2.5);
		return competition;
	}

}
