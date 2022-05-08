package fr.kleecontrib.port.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterForm {

	String email;
	String name;
	String firstName;
	AddressModel billAddress;
	List<AddressModel> deliveryAddress;
	String phoneNumber;
	String password;
}
