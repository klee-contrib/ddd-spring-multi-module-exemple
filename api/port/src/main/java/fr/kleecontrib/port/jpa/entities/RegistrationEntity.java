package fr.kleecontrib.port.jpa.entities;

import java.util.Objects;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "REGISTRATION")
@Entity
@NoArgsConstructor
public class RegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Column(name = "REG_ID")
	private Long id;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String firstName;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String phoneNumber;
	@Getter
	@Setter
	private String password;

	@Builder
	public RegistrationEntity(String email, String firstName, String name, String phoneNumber, String password) {
		this.email = email;
		this.firstName = firstName;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, name);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RegistrationEntity that = (RegistrationEntity) o;
		return email.equals(that.email) && firstName.equals(that.firstName) && name.equals(that.name);
	}
}
