package ng.nokiaBSC.application.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BtsNokia {
	@ManyToOne
	@JsonIgnore
	private BscNokia bsc;
	@Id
	private int bcf;
	private int localAreaCode;
	private String bcfAdminSate;
	private String bcfOperState;
	private int numberOfCellInBts;
	@OneToMany(mappedBy = "bts")
	private Collection<CellNokia>cellBts;
	
	
	
	public BtsNokia(int bcf, int localAreaCode, String bcfAdminSate, String bcfOperState) {
		super();
		this.bcf = bcf;
		this.localAreaCode = localAreaCode;
		this.bcfAdminSate = bcfAdminSate;
		this.bcfOperState = bcfOperState;
	}



	
	

}
