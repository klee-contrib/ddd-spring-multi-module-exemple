package fr.kleecontrib.domain.registration;

public record Address(String number, String road, String city, Integer zipCode, String country, boolean current) {

	public static Address hydrate(String number, String road, String city, Integer zipCode, String country,
			boolean current) {
		return new Address(number, road, city, zipCode, country, current);
	}
}
