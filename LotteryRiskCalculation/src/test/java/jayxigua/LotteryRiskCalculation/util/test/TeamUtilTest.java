package jayxigua.LotteryRiskCalculation.util.test;

import jayxigua.LotteryRiskCalculation.util.TeamUtil;

import org.junit.Test;

public class TeamUtilTest {
	@Test
	public void getTeam() {
		String info = "0,1,2,3,4,5,6";
		System.out.println(TeamUtil.getTeam("name", info));
	}

	@Test
	public void getByName() {
		System.out.println(TeamUtil.getTeamByName("湖人"));
		System.out.println(TeamUtil.getTeamByName("开拓者"));
	}
}
