package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptEcrituresAnalytiques;
import com.yewi.yewicore.recuperation.dtos.CptEcrituresAnalytiquesDTO;
import com.yewi.yewicore.recuperation.repository.CptEcrituresAnalytiquesRepository;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptEcrituresAnalytiquesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptEcrituresAnalytiquesService {

    @Autowired
    private CptEcrituresAnalytiquesRepository cptEcrituresAnalytiquesRepository;

    public Long save(CptEcrituresAnalytiquesVO vO) {
        CptEcrituresAnalytiques bean = new CptEcrituresAnalytiques();
        BeanUtils.copyProperties(vO, bean);
        bean = cptEcrituresAnalytiquesRepository.save(bean);
        return bean.getEcranaId();
    }

    public void delete(Long id) {
        cptEcrituresAnalytiquesRepository.deleteById(id);
    }

    public void update(Long id, CptEcrituresAnalytiquesUpdateVO vO) {
        CptEcrituresAnalytiques bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptEcrituresAnalytiquesRepository.save(bean);
    }

    public CptEcrituresAnalytiquesDTO getById(Long id) {
        CptEcrituresAnalytiques original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptEcrituresAnalytiquesDTO> query(CptEcrituresAnalytiquesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptEcrituresAnalytiquesDTO toDTO(CptEcrituresAnalytiques original) {
        CptEcrituresAnalytiquesDTO bean = new CptEcrituresAnalytiquesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptEcrituresAnalytiques requireOne(Long id) {
        return cptEcrituresAnalytiquesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
