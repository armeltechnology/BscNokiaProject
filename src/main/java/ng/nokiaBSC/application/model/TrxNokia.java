package ng.nokiaBSC.application.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class TrxNokia {
	
	
	@Id
	private String trxId;
	private int frequency;
	private int bcsuNumber;
	private int tsc;
	private char gtrx;
	private char etrx;
	private char pref;
	private int trxPower;
	private int dChannelLink;
	
	private String trxAdminState;
	private String trxOperState;
	@OneToMany(mappedBy = "trx")
	private Collection<CanalTrxNokia> channel;
	@ManyToOne
	@JsonIgnore
	private CellNokia cell;
	

	public TrxNokia() {
		super();
	}

	public TrxNokia(String trxId, int frequency, int bcsuNumber, char pref, String trxAdminState, String trxOperState) {
		super();
		this.trxId = trxId;
		this.frequency = frequency;
		this.bcsuNumber = bcsuNumber;
		this.pref = pref;
		this.trxAdminState = trxAdminState;
		this.trxOperState = trxOperState;
	}

	public TrxNokia(String trxId, int frequency, int bcsuNumber, int tsc, char gtrx, char etrx, char pref, int trxPower,
			int dChannelLink, String trxAdminState, String trxOperState, Collection<CanalTrxNokia> channel) {
		super();
		this.trxId = trxId;
		this.frequency = frequency;
		this.bcsuNumber = bcsuNumber;
		this.tsc = tsc;
		this.gtrx = gtrx;
		this.etrx = etrx;
		this.pref = pref;
		this.trxPower = trxPower;
		this.dChannelLink = dChannelLink;
		this.trxAdminState = trxAdminState;
		this.trxOperState = trxOperState;
		this.channel = channel;
	}

	public TrxNokia(String trxId, int frequency, int bcsuNumber, int tsc, char gtrx, char etrx, char pref, int trxPower,
			int dChannelLink, String trxAdminState, String trxOperState, Collection<CanalTrxNokia> channel,
			CellNokia cell) {
		super();
		this.trxId = trxId;
		this.frequency = frequency;
		this.bcsuNumber = bcsuNumber;
		this.tsc = tsc;
		this.gtrx = gtrx;
		this.etrx = etrx;
		this.pref = pref;
		this.trxPower = trxPower;
		this.dChannelLink = dChannelLink;
		this.trxAdminState = trxAdminState;
		this.trxOperState = trxOperState;
		this.channel = channel;
		this.cell = cell;
	}

	
	
	

}
