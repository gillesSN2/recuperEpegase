package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsHistoRef;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsHistoRefDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsHistoRefRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsHistoRefVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsHistoRefService {

    @Autowired
    private CmmProduitsHistoRefRepository cmmProduitsHistoRefRepository;

    public Long save(CmmProduitsHistoRefVO vO) {
        CmmProduitsHistoRef bean = new CmmProduitsHistoRef();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsHistoRefRepository.save(bean);
        return bean.getProhrfId();
    }

    public void delete(Long id) {
        cmmProduitsHistoRefRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsHistoRefUpdateVO vO) {
        CmmProduitsHistoRef bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsHistoRefRepository.save(bean);
    }

    public CmmProduitsHistoRefDTO getById(Long id) {
        CmmProduitsHistoRef original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsHistoRefDTO> query(CmmProduitsHistoRefQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsHistoRefDTO toDTO(CmmProduitsHistoRef original) {
        CmmProduitsHistoRefDTO bean = new CmmProduitsHistoRefDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsHistoRef requireOne(Long id) {
        return cmmProduitsHistoRefRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
