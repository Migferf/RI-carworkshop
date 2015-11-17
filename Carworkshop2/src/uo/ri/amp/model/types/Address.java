package uo.ri.amp.model.types;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private String zipCode;

	Address(){}
	
	public Address(String street, String city, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode="
				+ zipCode + "]";
	}

}
