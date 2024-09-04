package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.ImmBienGeranceEntete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImmBienGeranceEnteteRepository extends JpaRepository<ImmBienGeranceEntete, Long>, JpaSpecificationExecutor<ImmBienGeranceEntete> {

}