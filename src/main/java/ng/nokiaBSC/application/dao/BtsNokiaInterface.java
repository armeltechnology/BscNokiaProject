package ng.nokiaBSC.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nokiaBSC.application.model.BtsNokia;
@Repository
public interface BtsNokiaInterface extends JpaRepository<BtsNokia, Integer> {

}
