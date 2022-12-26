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
@Table(name="STATE")
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stateId")
	private Long Id;
	private String state;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_State_Id", referencedColumnName = "stateId")
	private List<City> cities;
	
	
}
