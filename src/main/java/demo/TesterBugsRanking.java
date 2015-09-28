package demo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TesterBugsRanking implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tester tester;
	private int totalBugsCount;
	private Map<String, Integer> bugsCountByDevice;
	
	public TesterBugsRanking() {
		totalBugsCount = 0;
		bugsCountByDevice = new HashMap<String, Integer>();
	}
	
	public Map<String, Integer> getBugsCountByDevice() {
		return bugsCountByDevice;
	}
	
	public void addDeviceAndCount(String device, int count) {
		// TODO: Should be only one entry per device, but should handle attempt to enter device > 1 times
		bugsCountByDevice.put(device, count);
		this.totalBugsCount += count;
	}
	
	public Integer getTotalBugsCount() {
		return totalBugsCount;
	}
	
	public String getFirstName() {
		return tester.getFirstName();
	}
	
	public String getLastName() {
		return tester.getLastName();
	}
	
	public void setTester(Tester tester) {
		this.tester = tester;
	}
	
	public String getCountryName() {
		return tester.getCountry().getName();
	}
}
