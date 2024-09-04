package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptTabFormule;
import com.yewi.yewicore.recuperation.dtos.CptTabFormuleDTO;
import com.yewi.yewicore.recuperation.repository.CptTabFormuleRepository;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabFormuleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptTabFormuleService {

    @Autowired
    private CptTabFormuleRepository cptTabFormuleRepository;

    public Long save(CptTabFormuleVO vO) {
        CptTabFormule bean = new CptTabFormule();
        BeanUtils.copyProperties(vO, bean);
        bean = cptTabFormuleRepository.save(bean);
        return bean.getTabforId();
    }

    public void delete(Long id) {
        cptTabFormuleRepository.deleteById(id);
    }

    public void update(Long id, CptTabFormuleUpdateVO vO) {
        CptTabFormule bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptTabFormuleRepository.save(bean);
    }

    public CptTabFormuleDTO getById(Long id) {
        CptTabFormule original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptTabFormuleDTO> query(CptTabFormuleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptTabFormuleDTO toDTO(CptTabFormule original) {
        CptTabFormuleDTO bean = new CptTabFormuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptTabFormule requireOne(Long id) {
        return cptTabFormuleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
