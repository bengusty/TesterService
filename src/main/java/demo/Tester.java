package demo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tester implements Serializable {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name="country_id")
    private Country country;
    @OneToMany
    @JoinTable(name="tester_devices",
    	joinColumns=@JoinColumn(name="tester_id"), inverseJoinColumns=@JoinColumn(name="devices_id"))
    private List<Device> devices;
    @OneToMany
    @JoinTable(name="tester_bugs",
		joinColumns=@JoinColumn(name="tester_id"), inverseJoinColumns=@JoinColumn(name="bugs_id"))
    private List<Bug> bugs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public List<Bug> getBugs() {
        return bugs;
    }
}
