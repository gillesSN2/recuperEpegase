package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmParc;
import com.yewi.yewicore.recuperation.dtos.CmmParcDTO;
import com.yewi.yewicore.recuperation.repository.CmmParcRepository;
import com.yewi.yewicore.recuperation.vo.CmmParcQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmParcUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmParcVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmParcService {

    @Autowired
    private CmmParcRepository cmmParcRepository;

    public Long save(CmmParcVO vO) {
        CmmParc bean = new CmmParc();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmParcRepository.save(bean);
        return bean.getPrcId();
    }

    public void delete(Long id) {
        cmmParcRepository.deleteById(id);
    }

    public void update(Long id, CmmParcUpdateVO vO) {
        CmmParc bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmParcRepository.save(bean);
    }

    public CmmParcDTO getById(Long id) {
        CmmParc original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmParcDTO> query(CmmParcQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmParcDTO toDTO(CmmParc original) {
        CmmParcDTO bean = new CmmParcDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmParc requireOne(Long id) {
        return cmmParcRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
