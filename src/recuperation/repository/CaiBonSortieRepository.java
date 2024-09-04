package recuperation.repository;

import com.yewi.yewicore.recuperation.domain.CaiBonSortie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CaiBonSortieRepository extends JpaRepository<CaiBonSortie, Long>, JpaSpecificationExecutor<CaiBonSortie> {

}