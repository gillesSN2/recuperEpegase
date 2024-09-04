package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptComplementInformations;
import com.yewi.yewicore.recuperation.dtos.CptComplementInformationsDTO;
import com.yewi.yewicore.recuperation.repository.CptComplementInformationsRepository;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptComplementInformationsService {

    @Autowired
    private CptComplementInformationsRepository cptComplementInformationsRepository;

    public Long save(CptComplementInformationsVO vO) {
        CptComplementInformations bean = new CptComplementInformations();
        BeanUtils.copyProperties(vO, bean);
        bean = cptComplementInformationsRepository.save(bean);
        return bean.getCplmenId();
    }

    public void delete(Long id) {
        cptComplementInformationsRepository.deleteById(id);
    }

    public void update(Long id, CptComplementInformationsUpdateVO vO) {
        CptComplementInformations bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptComplementInformationsRepository.save(bean);
    }

    public CptComplementInformationsDTO getById(Long id) {
        CptComplementInformations original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptComplementInformationsDTO> query(CptComplementInformationsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptComplementInformationsDTO toDTO(CptComplementInformations original) {
        CptComplementInformationsDTO bean = new CptComplementInformationsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptComplementInformations requireOne(Long id) {
        return cptComplementInformationsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
