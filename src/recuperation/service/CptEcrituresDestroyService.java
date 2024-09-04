package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptEcrituresDestroy;
import com.yewi.yewicore.recuperation.dtos.CptEcrituresDestroyDTO;
import com.yewi.yewicore.recuperation.repository.CptEcrituresDestroyRepository;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresDestroyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptEcrituresDestroyService {

    @Autowired
    private CptEcrituresDestroyRepository cptEcrituresDestroyRepository;

    public Long save(CptEcrituresDestroyVO vO) {
        CptEcrituresDestroy bean = new CptEcrituresDestroy();
        BeanUtils.copyProperties(vO, bean);
        bean = cptEcrituresDestroyRepository.save(bean);
        return bean.getEcrId();
    }

    public void delete(Long id) {
        cptEcrituresDestroyRepository.deleteById(id);
    }

    public void update(Long id, CptEcrituresDestroyUpdateVO vO) {
        CptEcrituresDestroy bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptEcrituresDestroyRepository.save(bean);
    }

    public CptEcrituresDestroyDTO getById(Long id) {
        CptEcrituresDestroy original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptEcrituresDestroyDTO> query(CptEcrituresDestroyQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptEcrituresDestroyDTO toDTO(CptEcrituresDestroy original) {
        CptEcrituresDestroyDTO bean = new CptEcrituresDestroyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptEcrituresDestroy requireOne(Long id) {
        return cptEcrituresDestroyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
