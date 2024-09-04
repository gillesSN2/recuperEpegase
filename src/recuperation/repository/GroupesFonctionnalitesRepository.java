package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.GroupesFonctionnalites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupesFonctionnalitesRepository extends JpaRepository<GroupesFonctionnalites, String>, JpaSpecificationExecutor<GroupesFonctionnalites> {

}