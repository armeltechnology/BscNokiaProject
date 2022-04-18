package ng.nokiaBSC.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.nokiaBSC.application.model.TrxNokia;

public interface TrxNokiaInterface extends JpaRepository<TrxNokia, String> {

}
