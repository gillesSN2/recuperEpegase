package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmConditionnement;
import com.yewi.yewicore.recuperation.dtos.CmmConditionnementDTO;
import com.yewi.yewicore.recuperation.repository.CmmConditionnementRepository;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmConditionnementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmConditionnementService {

    @Autowired
    private CmmConditionnementRepository cmmConditionnementRepository;

    public Long save(CmmConditionnementVO vO) {
        CmmConditionnement bean = new CmmConditionnement();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmConditionnementRepository.save(bean);
        return bean.getCdtId();
    }

    public void delete(Long id) {
        cmmConditionnementRepository.deleteById(id);
    }

    public void update(Long id, CmmConditionnementUpdateVO vO) {
        CmmConditionnement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmConditionnementRepository.save(bean);
    }

    public CmmConditionnementDTO getById(Long id) {
        CmmConditionnement original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmConditionnementDTO> query(CmmConditionnementQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmConditionnementDTO toDTO(CmmConditionnement original) {
        CmmConditionnementDTO bean = new CmmConditionnementDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmConditionnement requireOne(Long id) {
        return cmmConditionnementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
