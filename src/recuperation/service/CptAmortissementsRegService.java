package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptAmortissementsReg;
import com.yewi.yewicore.recuperation.dtos.CptAmortissementsRegDTO;
import com.yewi.yewicore.recuperation.repository.CptAmortissementsRegRepository;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptAmortissementsRegService {

    @Autowired
    private CptAmortissementsRegRepository cptAmortissementsRegRepository;

    public Long save(CptAmortissementsRegVO vO) {
        CptAmortissementsReg bean = new CptAmortissementsReg();
        BeanUtils.copyProperties(vO, bean);
        bean = cptAmortissementsRegRepository.save(bean);
        return bean.getAmoregId();
    }

    public void delete(Long id) {
        cptAmortissementsRegRepository.deleteById(id);
    }

    public void update(Long id, CptAmortissementsRegUpdateVO vO) {
        CptAmortissementsReg bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptAmortissementsRegRepository.save(bean);
    }

    public CptAmortissementsRegDTO getById(Long id) {
        CptAmortissementsReg original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptAmortissementsRegDTO> query(CptAmortissementsRegQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptAmortissementsRegDTO toDTO(CptAmortissementsReg original) {
        CptAmortissementsRegDTO bean = new CptAmortissementsRegDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptAmortissementsReg requireOne(Long id) {
        return cptAmortissementsRegRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
