package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptPlanBugetaireCompte;
import com.yewi.yewicore.recuperation.dtos.CptPlanBugetaireCompteDTO;
import com.yewi.yewicore.recuperation.repository.CptPlanBugetaireCompteRepository;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteQueryVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptPlanBugetaireCompteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptPlanBugetaireCompteService {

    @Autowired
    private CptPlanBugetaireCompteRepository cptPlanBugetaireCompteRepository;

    public Long save(CptPlanBugetaireCompteVO vO) {
        CptPlanBugetaireCompte bean = new CptPlanBugetaireCompte();
        BeanUtils.copyProperties(vO, bean);
        bean = cptPlanBugetaireCompteRepository.save(bean);
        return bean.getPlbcptId();
    }

    public void delete(Long id) {
        cptPlanBugetaireCompteRepository.deleteById(id);
    }

    public void update(Long id, CptPlanBugetaireCompteUpdateVO vO) {
        CptPlanBugetaireCompte bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptPlanBugetaireCompteRepository.save(bean);
    }

    public CptPlanBugetaireCompteDTO getById(Long id) {
        CptPlanBugetaireCompte original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptPlanBugetaireCompteDTO> query(CptPlanBugetaireCompteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptPlanBugetaireCompteDTO toDTO(CptPlanBugetaireCompte original) {
        CptPlanBugetaireCompteDTO bean = new CptPlanBugetaireCompteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptPlanBugetaireCompte requireOne(Long id) {
        return cptPlanBugetaireCompteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
