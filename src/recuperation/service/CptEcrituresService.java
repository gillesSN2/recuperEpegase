package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptEcritures;
import com.yewi.yewicore.recuperation.dtos.CptEcrituresDTO;
import com.yewi.yewicore.recuperation.repository.CptEcrituresRepository;
import com.yewi.yewicore.recuperation.vo.CptEcrituresQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptEcrituresService {

    @Autowired
    private CptEcrituresRepository cptEcrituresRepository;

    public Long save(CptEcrituresVO vO) {
        CptEcritures bean = new CptEcritures();
        BeanUtils.copyProperties(vO, bean);
        bean = cptEcrituresRepository.save(bean);
        return bean.getEcrId();
    }

    public void delete(Long id) {
        cptEcrituresRepository.deleteById(id);
    }

    public void update(Long id, CptEcrituresUpdateVO vO) {
        CptEcritures bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptEcrituresRepository.save(bean);
    }

    public CptEcrituresDTO getById(Long id) {
        CptEcritures original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptEcrituresDTO> query(CptEcrituresQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptEcrituresDTO toDTO(CptEcritures original) {
        CptEcrituresDTO bean = new CptEcrituresDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptEcritures requireOne(Long id) {
        return cptEcrituresRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
