package in.umt.bindings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COUNTRY")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="countryId")
	private Long Id;
	
	private String countryName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_country_Id", referencedColumnName = "countryId")
	private List<State> states;
	
	
	
}
