package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.UserFonctionnaliteDroit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserFonctionnaliteDroitRepository extends JpaRepository<UserFonctionnaliteDroit, Long>, JpaSpecificationExecutor<UserFonctionnaliteDroit> {

}