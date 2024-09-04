package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptTabElement;
import com.yewi.yewicore.recuperation.dtos.CptTabElementDTO;
import com.yewi.yewicore.recuperation.repository.CptTabElementRepository;
import com.yewi.yewicore.recuperation.vo.CptTabElementQueryVO;
import com.yewi.yewicore.recuperation.vo.CptTabElementUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptTabElementVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptTabElementService {

    @Autowired
    private CptTabElementRepository cptTabElementRepository;

    public Long save(CptTabElementVO vO) {
        CptTabElement bean = new CptTabElement();
        BeanUtils.copyProperties(vO, bean);
        bean = cptTabElementRepository.save(bean);
        return bean.getTabeleId();
    }

    public void delete(Long id) {
        cptTabElementRepository.deleteById(id);
    }

    public void update(Long id, CptTabElementUpdateVO vO) {
        CptTabElement bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptTabElementRepository.save(bean);
    }

    public CptTabElementDTO getById(Long id) {
        CptTabElement original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptTabElementDTO> query(CptTabElementQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptTabElementDTO toDTO(CptTabElement original) {
        CptTabElementDTO bean = new CptTabElementDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptTabElement requireOne(Long id) {
        return cptTabElementRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
