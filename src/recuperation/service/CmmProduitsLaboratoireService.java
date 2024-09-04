package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmProduitsLaboratoire;
import com.yewi.yewicore.recuperation.dtos.CmmProduitsLaboratoireDTO;
import com.yewi.yewicore.recuperation.repository.CmmProduitsLaboratoireRepository;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmProduitsLaboratoireService {

    @Autowired
    private CmmProduitsLaboratoireRepository cmmProduitsLaboratoireRepository;

    public Long save(CmmProduitsLaboratoireVO vO) {
        CmmProduitsLaboratoire bean = new CmmProduitsLaboratoire();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmProduitsLaboratoireRepository.save(bean);
        return bean.getProlabId();
    }

    public void delete(Long id) {
        cmmProduitsLaboratoireRepository.deleteById(id);
    }

    public void update(Long id, CmmProduitsLaboratoireUpdateVO vO) {
        CmmProduitsLaboratoire bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmProduitsLaboratoireRepository.save(bean);
    }

    public CmmProduitsLaboratoireDTO getById(Long id) {
        CmmProduitsLaboratoire original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmProduitsLaboratoireDTO> query(CmmProduitsLaboratoireQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmProduitsLaboratoireDTO toDTO(CmmProduitsLaboratoire original) {
        CmmProduitsLaboratoireDTO bean = new CmmProduitsLaboratoireDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmProduitsLaboratoire requireOne(Long id) {
        return cmmProduitsLaboratoireRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
