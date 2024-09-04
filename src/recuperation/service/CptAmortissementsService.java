package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptAmortissements;
import com.yewi.yewicore.recuperation.dtos.CptAmortissementsDTO;
import com.yewi.yewicore.recuperation.repository.CptAmortissementsRepository;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptAmortissementsService {

    @Autowired
    private CptAmortissementsRepository cptAmortissementsRepository;

    public Long save(CptAmortissementsVO vO) {
        CptAmortissements bean = new CptAmortissements();
        BeanUtils.copyProperties(vO, bean);
        bean = cptAmortissementsRepository.save(bean);
        return bean.getAmoId();
    }

    public void delete(Long id) {
        cptAmortissementsRepository.deleteById(id);
    }

    public void update(Long id, CptAmortissementsUpdateVO vO) {
        CptAmortissements bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptAmortissementsRepository.save(bean);
    }

    public CptAmortissementsDTO getById(Long id) {
        CptAmortissements original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptAmortissementsDTO> query(CptAmortissementsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptAmortissementsDTO toDTO(CptAmortissements original) {
        CptAmortissementsDTO bean = new CptAmortissementsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptAmortissements requireOne(Long id) {
        return cptAmortissementsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
