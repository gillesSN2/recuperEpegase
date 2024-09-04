package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProductionLigne;
import com.yewi.yewicore.recuperation.dtos.CmmProductionLigneDTO;
import com.yewi.yewicore.recuperation.repository.CmmProductionLigneRepository;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProductionLigneService {

    @Autowired
    private CmmProductionLigneRepository cmmProductionLigneRepository;

    public Long save(CmmProductionLigneVO vO) {
        CmmProductionLigne bean = new CmmProductionLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProductionLigneRepository.save(bean);
        return bean.getLigId();
    }

    public void delete(Long id) {
        cmmProductionLigneRepository.deleteById(id);
    }

    public void update(Long id, CmmProductionLigneUpdateVO vO) {
        CmmProductionLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProductionLigneRepository.save(bean);
    }

    public CmmProductionLigneDTO getById(Long id) {
        CmmProductionLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProductionLigneDTO> query(CmmProductionLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProductionLigneDTO toDTO(CmmProductionLigne original) {
        CmmProductionLigneDTO bean = new CmmProductionLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProductionLigne requireOne(Long id) {
        return cmmProductionLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
