package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmDepartement;
import com.yewi.yewicore.recuperation.dtos.CmmDepartementDTO;
import com.yewi.yewicore.recuperation.repository.CmmDepartementRepository;
import com.yewi.yewicore.recuperation.vo.CmmDepartementQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmDepartementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmDepartementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmDepartementService {

    @Autowired
    private CmmDepartementRepository cmmDepartementRepository;

    public Long save(CmmDepartementVO vO) {
        CmmDepartement bean = new CmmDepartement();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmDepartementRepository.save(bean);
        return bean.getDepId();
    }

    public void delete(Long id) {
        cmmDepartementRepository.deleteById(id);
    }

    public void update(Long id, CmmDepartementUpdateVO vO) {
        CmmDepartement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmDepartementRepository.save(bean);
    }

    public CmmDepartementDTO getById(Long id) {
        CmmDepartement original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmDepartementDTO> query(CmmDepartementQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmDepartementDTO toDTO(CmmDepartement original) {
        CmmDepartementDTO bean = new CmmDepartementDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmDepartement requireOne(Long id) {
        return cmmDepartementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
