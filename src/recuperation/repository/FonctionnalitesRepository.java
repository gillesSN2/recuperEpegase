package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Fonctionnalites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FonctionnalitesRepository extends JpaRepository<Fonctionnalites, String>, JpaSpecificationExecutor<Fonctionnalites> {

}