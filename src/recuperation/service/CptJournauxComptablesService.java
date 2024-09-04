package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptJournauxComptables;
import com.yewi.yewicore.recuperation.dtos.CptJournauxComptablesDTO;
import com.yewi.yewicore.recuperation.repository.CptJournauxComptablesRepository;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesQueryVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptJournauxComptablesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptJournauxComptablesService {

    @Autowired
    private CptJournauxComptablesRepository cptJournauxComptablesRepository;

    public Long save(CptJournauxComptablesVO vO) {
        CptJournauxComptables bean = new CptJournauxComptables();
        BeanUtils.copyProperties(vO, bean);
        bean = cptJournauxComptablesRepository.save(bean);
        return bean.getPljId();
    }

    public void delete(Long id) {
        cptJournauxComptablesRepository.deleteById(id);
    }

    public void update(Long id, CptJournauxComptablesUpdateVO vO) {
        CptJournauxComptables bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptJournauxComptablesRepository.save(bean);
    }

    public CptJournauxComptablesDTO getById(Long id) {
        CptJournauxComptables original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptJournauxComptablesDTO> query(CptJournauxComptablesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptJournauxComptablesDTO toDTO(CptJournauxComptables original) {
        CptJournauxComptablesDTO bean = new CptJournauxComptablesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptJournauxComptables requireOne(Long id) {
        return cptJournauxComptablesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
