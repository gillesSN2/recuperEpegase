package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long>, JpaSpecificationExecutor<Utilisateurs> {

}