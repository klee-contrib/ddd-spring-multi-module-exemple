package fr.kleecontrib.port.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressModel {

	private String number;
	private String road;
	private String city;
	private Integer zipCode;
	private String country;
	private boolean current;
}
