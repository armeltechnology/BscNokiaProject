package ng.nokiaBSC.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nokiaBSC.application.model.BscNokia;
@Repository
public interface BscNokiaInterface extends JpaRepository<BscNokia, Integer> {

}
