package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaysRepository extends JpaRepository<Pays, String>, JpaSpecificationExecutor<Pays> {

}