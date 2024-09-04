package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduits;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsService {

    @Autowired
    private CmmProduitsRepository cmmProduitsRepository;

    public Long save(CmmProduitsVO vO) {
        CmmProduits bean = new CmmProduits();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsRepository.save(bean);
        return bean.getProId();
    }

    public void delete(Long id) {
        cmmProduitsRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsUpdateVO vO) {
        CmmProduits bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsRepository.save(bean);
    }

    public CmmProduitsDTO getById(Long id) {
        CmmProduits original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsDTO> query(CmmProduitsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsDTO toDTO(CmmProduits original) {
        CmmProduitsDTO bean = new CmmProduitsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduits requireOne(Long id) {
        return cmmProduitsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
