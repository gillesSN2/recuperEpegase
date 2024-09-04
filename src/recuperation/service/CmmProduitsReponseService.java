package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsReponse;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsReponseDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsReponseRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsReponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsReponseService {

    @Autowired
    private CmmProduitsReponseRepository cmmProduitsReponseRepository;

    public Long save(CmmProduitsReponseVO vO) {
        CmmProduitsReponse bean = new CmmProduitsReponse();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsReponseRepository.save(bean);
        return bean.getProrepId();
    }

    public void delete(Long id) {
        cmmProduitsReponseRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsReponseUpdateVO vO) {
        CmmProduitsReponse bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsReponseRepository.save(bean);
    }

    public CmmProduitsReponseDTO getById(Long id) {
        CmmProduitsReponse original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsReponseDTO> query(CmmProduitsReponseQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsReponseDTO toDTO(CmmProduitsReponse original) {
        CmmProduitsReponseDTO bean = new CmmProduitsReponseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsReponse requireOne(Long id) {
        return cmmProduitsReponseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
