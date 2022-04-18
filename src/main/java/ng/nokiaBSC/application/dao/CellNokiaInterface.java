package ng.nokiaBSC.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ng.nokiaBSC.application.model.CellNokia;
@Repository
public interface CellNokiaInterface extends JpaRepository<CellNokia, Integer> {

}
