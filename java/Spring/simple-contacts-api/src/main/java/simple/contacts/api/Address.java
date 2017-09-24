package simple.contacts.api;

public class Address {

    private int id;
    private String street;
    private String city;
    private String postal_code;
    private String country;

    public Address(int id, String street, String city, String postal_code, String country) {
	this.id = id;
	this.street = street;
	this.city = city;
	this.postal_code = postal_code;
	this.country = country;
    }

    public int getId() {
	return id;
    }

    public String getStreet() {
	return street;
    }

    public String getCity() {
	return city;
    }
    public String getPostalCode() {
	return postal_code;
    }
    public String getCountry() {
	return country;
    }
}
