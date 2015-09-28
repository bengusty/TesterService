package demo.repository;

import java.util.ArrayList;
import java.util.List;

import demo.HibernateUtil;
import demo.Tester;
import demo.TesterBugsRanking;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.google.common.base.Joiner;

public interface TesterRepository {
	/***
	 * Returns a list of testers for the given countries and with bugs reported for the given devices.
	 * Empty countries and devices lists are treated as ALL.
	 * List is sorted in order of total number of bugs reported for the devices.
	 * @param countries
	 * @param devices
	 * @return
	 */
	List<TesterBugsRanking> findByCountriesInAndDevicesIn(List<String> countries, List<String> devices);
}
