package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienTravauxEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienTravauxEnteteRepository extends JpaRepository<ImmBienTravauxEntete, Long>, JpaSpecificationExecutor<ImmBienTravauxEntete> {

}