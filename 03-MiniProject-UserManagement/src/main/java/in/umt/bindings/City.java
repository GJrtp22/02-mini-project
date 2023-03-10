package in.umt.bindings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CITY")
public class City {
	@Id
	
	private Long Id;
	private String city;
	
	@ManyToOne
	@JoinColumn(name="fk_stateId")
	private State state;
	
	
}
