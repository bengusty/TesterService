package demo;

import java.util.List;

/**
 * Class for inputting a list of countries and devices via @RequestBody
 * @author gustaca1
 */
public class RankingsInput {
	private List<String> countries;
	private List<String> devices;
	
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	public List<String> getDevices() {
		return devices;
	}
	public void setDevices(List<String> devices) {
		this.devices = devices;
	}
}
