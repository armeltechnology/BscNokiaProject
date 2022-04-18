package ng.nokiaBSC.application.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class BscNokia {
	@Id
	private int id;
	private String bsName;
	private String ipAdressBs;
	private String userNameBsNokia;
	private String passwordBsNokia;
	@OneToMany(mappedBy = "bsc")
	
	private Collection<BtsNokia> bts;
	@OneToMany(mappedBy = "bsc")
	private Collection<CellNokia> cell;
	
	
	public BscNokia() {
		super();
	}

	public BscNokia(int id, String bsName, String ipAdressBs, String userNameBsNokia, String passwordBsNokia) {
		super();
		this.id = id;
		this.bsName = bsName;
		this.ipAdressBs = ipAdressBs;
		this.userNameBsNokia = userNameBsNokia;
		this.passwordBsNokia = passwordBsNokia;
	}

	public BscNokia(int id, String bsName, String ipAdressBs, String userNameBsNokia, String passwordBsNokia,
			Collection<BtsNokia> bts, Collection<CellNokia> cell) {
		super();
		this.id = id;
		this.bsName = bsName;
		this.ipAdressBs = ipAdressBs;
		this.userNameBsNokia = userNameBsNokia;
		this.passwordBsNokia = passwordBsNokia;
		this.bts = bts;
		this.cell = cell;
		
	}
	

}
