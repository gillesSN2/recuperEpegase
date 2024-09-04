package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmReunionEntete;
import com.yewi.yewicore.recuperation.dtos.CmmReunionEnteteDTO;
import com.yewi.yewicore.recuperation.repository.CmmReunionEnteteRepository;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmReunionEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmReunionEnteteService {

    @Autowired
    private CmmReunionEnteteRepository cmmReunionEnteteRepository;

    public Long save(CmmReunionEnteteVO vO) {
        CmmReunionEntete bean = new CmmReunionEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmReunionEnteteRepository.save(bean);
        return bean.getReuId();
    }

    public void delete(Long id) {
        cmmReunionEnteteRepository.deleteById(id);
    }

    public void update(Long id, CmmReunionEnteteUpdateVO vO) {
        CmmReunionEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmReunionEnteteRepository.save(bean);
    }

    public CmmReunionEnteteDTO getById(Long id) {
        CmmReunionEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmReunionEnteteDTO> query(CmmReunionEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmReunionEnteteDTO toDTO(CmmReunionEntete original) {
        CmmReunionEnteteDTO bean = new CmmReunionEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmReunionEntete requireOne(Long id) {
        return cmmReunionEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
