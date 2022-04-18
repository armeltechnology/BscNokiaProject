package ng.nokiaBSC.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class CanalTrxNokia {
	@Id
	private int rtslId;
	private String typeChannel;
	private String chanAdminState;
	private String chanOperState;
	@ManyToOne
	@JsonIgnore
	private TrxNokia trx;
	public CanalTrxNokia() {
		super();
		System.out.println("creation of channel N°:"+""+getRtslId());
		
	}
	public CanalTrxNokia(int rtslId, String typeChannel, String chanAdminState, String chanOperState) {
		super();
		System.out.println("creation of channel N°:"+""+getRtslId());
		this.rtslId = rtslId;
		this.typeChannel = typeChannel;
		this.chanAdminState = chanAdminState;
		this.chanOperState = chanOperState;
	}
	public CanalTrxNokia(String typeChannel) {
		super();
		System.out.println("creation of channel N°:"+""+getRtslId());
		this.typeChannel = typeChannel;
	}
	

	
	

}
