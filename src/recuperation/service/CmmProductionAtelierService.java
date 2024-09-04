package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProductionAtelier;
import com.yewi.yewicore.recuperation.dtos.CmmProductionAtelierDTO;
import com.yewi.yewicore.recuperation.repository.CmmProductionAtelierRepository;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProductionAtelierVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProductionAtelierService {

    @Autowired
    private CmmProductionAtelierRepository cmmProductionAtelierRepository;

    public Long save(CmmProductionAtelierVO vO) {
        CmmProductionAtelier bean = new CmmProductionAtelier();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProductionAtelierRepository.save(bean);
        return bean.getAteId();
    }

    public void delete(Long id) {
        cmmProductionAtelierRepository.deleteById(id);
    }

    public void update(Long id, CmmProductionAtelierUpdateVO vO) {
        CmmProductionAtelier bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProductionAtelierRepository.save(bean);
    }

    public CmmProductionAtelierDTO getById(Long id) {
        CmmProductionAtelier original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProductionAtelierDTO> query(CmmProductionAtelierQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProductionAtelierDTO toDTO(CmmProductionAtelier original) {
        CmmProductionAtelierDTO bean = new CmmProductionAtelierDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProductionAtelier requireOne(Long id) {
        return cmmProductionAtelierRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
