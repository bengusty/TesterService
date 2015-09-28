package demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;

import demo.QBug;
import demo.QTester;
import demo.Tester;
import demo.TesterBugsRanking;
import demo.TesterBugsRankingComparator;
import demo.TesterServiceApplication;
import edu.emory.mathcs.backport.java.util.Collections;

public class TesterRepositoryImpl implements TesterRepository {
	/**
	 * Returns BooleanExpression containing countries chosen or null if none
	 * @param countries
	 * @param tester
	 * @return BooleanExpression
	 */
	private BooleanExpression countriesChosen(List<String> countries, QTester tester) {
	    return countries.size() > 0 ? tester.country.name.in(countries) : null;       
	}

	/***
	 * Returns BooleanExpression containing devices chosen or null if none
	 * @param devices
	 * @param tester
	 * @return BooleanExpression 
	 */
	private BooleanExpression devicesChosen(List<String> devices, QTester tester) {
	    return devices.size() > 0 ? tester.bugs.any().device.description.in(devices) : null;       
	}

	@Override
	public List<TesterBugsRanking> findByCountriesInAndDevicesIn(List<String> countries, List<String> devices) {
		// TODO: Put the below in a factory class and method
		Configuration configuration = new Configuration().setNamingStrategy(ImprovedNamingStrategy.INSTANCE).configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
        
		// QueryDsl types from code from domain entities
		QTester tester = QTester.tester;
		QBug bug = QBug.bug;
		// Querying interface object
		JPQLQuery query = new HibernateQuery(session); 

		// Query the system for a list of testers fitting the chosen country and device criteria.
		Predicate countriesPred = countriesChosen(countries, tester);
		Predicate devicesPred = devicesChosen(devices, tester);
		List<Tester> testers = query.from(tester).where(countriesPred, devicesPred)
			// Would like to sort testers by something like this; using Comparator for now
			//.orderBy(tester.bugs.any().device.description.in(devices).countDistinct().desc())
			.list(tester);
		
		// Query the system for each tester's bugs logged for the chosen devices.
		// Add the information to a TesterBugsRanking object for sorting and serialization.
		List<TesterBugsRanking> rankings = new ArrayList<TesterBugsRanking>();
		for (Tester t: testers) {
			query = new HibernateQuery(session);
			Map<String, Long> testerBugs = query.from(bug)
				.where(bug.device.description.in(devices).and(bug.tester.id.eq(t.getId())))
				.groupBy(bug.device.description).map(bug.device.description, bug.countDistinct());
			TesterBugsRanking ranking = new TesterBugsRanking();
			ranking.setTester(t);
			for (Map.Entry<String, Long> entry : testerBugs.entrySet()) {
				ranking.addDeviceAndCount(entry.getKey(), entry.getValue().intValue());
			}
			rankings.add(ranking);
		}
		
		// Sort the tester rankings by the total number of bugs for chosen parameters
		Collections.sort(rankings, new TesterBugsRankingComparator());
		
		return rankings;
	}
}
