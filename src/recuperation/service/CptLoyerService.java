package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CptLoyer;
import com.yewi.yewicore.recuperation.dtos.CptLoyerDTO;
import com.yewi.yewicore.recuperation.repository.CptLoyerRepository;
import com.yewi.yewicore.recuperation.vo.CptLoyerQueryVO;
import com.yewi.yewicore.recuperation.vo.CptLoyerUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptLoyerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CptLoyerService {

    @Autowired
    private CptLoyerRepository cptLoyerRepository;

    public Long save(CptLoyerVO vO) {
        CptLoyer bean = new CptLoyer();
        BeanUtils.copyProperties(vO, bean);
        bean = cptLoyerRepository.save(bean);
        return bean.getLoyId();
    }

    public void delete(Long id) {
        cptLoyerRepository.deleteById(id);
    }

    public void update(Long id, CptLoyerUpdateVO vO) {
        CptLoyer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cptLoyerRepository.save(bean);
    }

    public CptLoyerDTO getById(Long id) {
        CptLoyer original = requireOne(id);
        return toDTO(original);
    }

    public Page<CptLoyerDTO> query(CptLoyerQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CptLoyerDTO toDTO(CptLoyer original) {
        CptLoyerDTO bean = new CptLoyerDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CptLoyer requireOne(Long id) {
        return cptLoyerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
