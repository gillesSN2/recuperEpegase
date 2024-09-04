package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmService;
import com.yewi.yewicore.recuperation.dtos.CmmServiceDTO;
import com.yewi.yewicore.recuperation.repository.CmmServiceRepository;
import com.yewi.yewicore.recuperation.vo.CmmServiceQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmServiceUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmServiceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmServiceService {

    @Autowired
    private CmmServiceRepository cmmServiceRepository;

    public Long save(CmmServiceVO vO) {
        CmmService bean = new CmmService();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmServiceRepository.save(bean);
        return bean.getSerId();
    }

    public void delete(Long id) {
        cmmServiceRepository.deleteById(id);
    }

    public void update(Long id, CmmServiceUpdateVO vO) {
        CmmService bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmServiceRepository.save(bean);
    }

    public CmmServiceDTO getById(Long id) {
        CmmService original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmServiceDTO> query(CmmServiceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmServiceDTO toDTO(CmmService original) {
        CmmServiceDTO bean = new CmmServiceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmService requireOne(Long id) {
        return cmmServiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
