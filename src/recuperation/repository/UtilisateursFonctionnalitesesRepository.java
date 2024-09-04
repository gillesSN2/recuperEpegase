package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.UtilisateursFonctionnaliteses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtilisateursFonctionnalitesesRepository extends JpaRepository<UtilisateursFonctionnaliteses, String>, JpaSpecificationExecutor<UtilisateursFonctionnaliteses> {

}