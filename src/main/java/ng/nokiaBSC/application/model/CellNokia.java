package ng.nokiaBSC.application.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@AllArgsConstructor
public class CellNokia {
	@Id
	private int cellId;
	private String cellName;
	private String bcf;
	private int localareaCode;
	private int numberOfTrxIncell;
	private String btsId;
	private String cellAdminState;
	private String cellOperState;
	private int bscuNumber;
	private String omLink;
	private String omState;
	private int userHalfRate;
	private int userFullRate;
	private int userGprs;
	@OneToMany(mappedBy = "cell")
	
	 private Collection<TrxNokia> trxCell;
	@ManyToOne
	@JsonIgnore
	private BscNokia bsc;
	
	@ManyToOne
	@JsonIgnore
	private BtsNokia bts;
	public CellNokia() {
		super();
	}
	public CellNokia(String cellName, String bcf, int cellId, int localareaCode, String btsId, String cellAdminState,
			String cellOperState, int bscuNumber, String omLink, String omState, int userHalfRate, int userFullRate,
			int userGprs) {
		super();
		this.cellName = cellName;
		this.bcf = bcf;
		this.cellId = cellId;
		this.localareaCode = localareaCode;
		this.btsId = btsId;
		this.cellAdminState = cellAdminState;
		this.cellOperState = cellOperState;
		this.bscuNumber = bscuNumber;
		this.omLink = omLink;
		this.omState = omState;
		this.userHalfRate = userHalfRate;
		this.userFullRate = userFullRate;
		this.userGprs = userGprs;
	}
	public CellNokia(String cellName, String bcf, int cellId, int localareaCode, int numberOfTrxIncell, String btsId,
			String cellAdminState, String cellOperState, int bscuNumber, String omLink, String omState,
			int userHalfRate, int userFullRate, int userGprs, Collection<TrxNokia> trxCell) {
		super();
		this.cellName = cellName;
		this.bcf = bcf;
		this.cellId = cellId;
		this.localareaCode = localareaCode;
		this.numberOfTrxIncell = numberOfTrxIncell;
		this.btsId = btsId;
		this.cellAdminState = cellAdminState;
		this.cellOperState = cellOperState;
		this.bscuNumber = bscuNumber;
		this.omLink = omLink;
		this.omState = omState;
		this.userHalfRate = userHalfRate;
		this.userFullRate = userFullRate;
		this.userGprs = userGprs;
		this.trxCell = trxCell;
	}
	

}
