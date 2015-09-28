package demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.repository.CountryRepository;
import demo.repository.DeviceRepository;
import demo.repository.TesterRepository;
import demo.repository.TesterRepositoryImpl;

@RestController
public class RankingsController {
	@Autowired ApplicationContext context;
	@Autowired private HttpServletRequest request;
	
	/***
	 * Returns a list of all country names
	 * @return
	 */
	@RequestMapping(value="/countries", method=RequestMethod.GET)
	private ResponseEntity<List<String>> getCountries() {	 
		List<String> countries = new ArrayList<String>();
		CountryRepository repo = context.getBean(CountryRepository.class);
	
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		List<Country> countriesList = (List<Country>) repo.findAll(sort);
		
		for (Country c : countriesList) {
			countries.add(c.getName());
		}
		
		return new ResponseEntity<List<String>>(countries, HttpStatus.OK);
	}
	
	/***
	 * Returns a list of all device names
	 * @return
	 */
	@RequestMapping(value="/devices", method=RequestMethod.GET)
	private ResponseEntity<List<String>> getDevices() {	 
		List<String> devices = new ArrayList<String>();
		DeviceRepository repo = context.getBean(DeviceRepository.class);
		Sort sort = new Sort(Sort.Direction.ASC, "description");
		
		List<Device> devicesList = (List<Device>) repo.findAll(sort);
		
		for (Device d : devicesList) {
			devices.add(d.getDescription());
		}
		
		return new ResponseEntity<List<String>>(devices, HttpStatus.OK);
	}
	
	/***
	 * Return testers in the given countries in order of bugs for the given devices.
	 * @param countriesDevices
	 * @return
	 */
	@RequestMapping(value="/rankings", method=RequestMethod.POST)
	public ResponseEntity<List<TesterBugsRanking>> getRankings(@RequestBody RankingsInput countriesDevices) {
		TesterRepository repo = new TesterRepositoryImpl();
		List<TesterBugsRanking> rankings = repo.findByCountriesInAndDevicesIn(countriesDevices.getCountries(), countriesDevices.getDevices());
		return new ResponseEntity<List<TesterBugsRanking>>(rankings, HttpStatus.OK);
	}
}
