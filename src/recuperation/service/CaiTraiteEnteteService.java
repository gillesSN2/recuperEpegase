package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiTraiteEntete;
import com.yewi.yewicore.recuperation.dtos.CaiTraiteEnteteDTO;
import com.yewi.yewicore.recuperation.repository.CaiTraiteEnteteRepository;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiTraiteEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiTraiteEnteteService {

    @Autowired
    private CaiTraiteEnteteRepository caiTraiteEnteteRepository;

    public Long save(CaiTraiteEnteteVO vO) {
        CaiTraiteEntete bean = new CaiTraiteEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = caiTraiteEnteteRepository.save(bean);
        return bean.getTrtId();
    }

    public void delete(Long id) {
        caiTraiteEnteteRepository.deleteById(id);
    }

    public void update(Long id, CaiTraiteEnteteUpdateVO vO) {
        CaiTraiteEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiTraiteEnteteRepository.save(bean);
    }

    public CaiTraiteEnteteDTO getById(Long id) {
        CaiTraiteEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiTraiteEnteteDTO> query(CaiTraiteEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiTraiteEnteteDTO toDTO(CaiTraiteEntete original) {
        CaiTraiteEnteteDTO bean = new CaiTraiteEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiTraiteEntete requireOne(Long id) {
        return caiTraiteEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
