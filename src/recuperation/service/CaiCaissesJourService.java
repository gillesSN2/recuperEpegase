package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiCaissesJour;
import com.yewi.yewicore.recuperation.dtos.CaiCaissesJourDTO;
import com.yewi.yewicore.recuperation.repository.CaiCaissesJourRepository;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesJourVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiCaissesJourService {

    @Autowired
    private CaiCaissesJourRepository caiCaissesJourRepository;

    public Long save(CaiCaissesJourVO vO) {
        CaiCaissesJour bean = new CaiCaissesJour();
        BeanUtils.copyProperties(vO, bean);
        bean = caiCaissesJourRepository.save(bean);
        return bean.getCaijouId();
    }

    public void delete(Long id) {
        caiCaissesJourRepository.deleteById(id);
    }

    public void update(Long id, CaiCaissesJourUpdateVO vO) {
        CaiCaissesJour bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiCaissesJourRepository.save(bean);
    }

    public CaiCaissesJourDTO getById(Long id) {
        CaiCaissesJour original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiCaissesJourDTO> query(CaiCaissesJourQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiCaissesJourDTO toDTO(CaiCaissesJour original) {
        CaiCaissesJourDTO bean = new CaiCaissesJourDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiCaissesJour requireOne(Long id) {
        return caiCaissesJourRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
