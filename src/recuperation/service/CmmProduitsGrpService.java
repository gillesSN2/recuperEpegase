package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsGrp;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsGrpDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsGrpRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsGrpVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsGrpService {

    @Autowired
    private CmmProduitsGrpRepository cmmProduitsGrpRepository;

    public Long save(CmmProduitsGrpVO vO) {
        CmmProduitsGrp bean = new CmmProduitsGrp();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsGrpRepository.save(bean);
        return bean.getProgrpId();
    }

    public void delete(Long id) {
        cmmProduitsGrpRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsGrpUpdateVO vO) {
        CmmProduitsGrp bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsGrpRepository.save(bean);
    }

    public CmmProduitsGrpDTO getById(Long id) {
        CmmProduitsGrp original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsGrpDTO> query(CmmProduitsGrpQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsGrpDTO toDTO(CmmProduitsGrp original) {
        CmmProduitsGrpDTO bean = new CmmProduitsGrpDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsGrp requireOne(Long id) {
        return cmmProduitsGrpRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
