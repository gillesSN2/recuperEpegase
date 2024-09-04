package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmSignature;
import com.yewi.yewicore.recuperation.dtos.CmmSignatureDTO;
import com.yewi.yewicore.recuperation.repository.CmmSignatureRepository;
import com.yewi.yewicore.recuperation.vo.CmmSignatureQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSignatureUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSignatureVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmSignatureService {

    @Autowired
    private CmmSignatureRepository cmmSignatureRepository;

    public Long save(CmmSignatureVO vO) {
        CmmSignature bean = new CmmSignature();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmSignatureRepository.save(bean);
        return bean.getSgrId();
    }

    public void delete(Long id) {
        cmmSignatureRepository.deleteById(id);
    }

    public void update(Long id, CmmSignatureUpdateVO vO) {
        CmmSignature bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmSignatureRepository.save(bean);
    }

    public CmmSignatureDTO getById(Long id) {
        CmmSignature original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmSignatureDTO> query(CmmSignatureQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmSignatureDTO toDTO(CmmSignature original) {
        CmmSignatureDTO bean = new CmmSignatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmSignature requireOne(Long id) {
        return cmmSignatureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
