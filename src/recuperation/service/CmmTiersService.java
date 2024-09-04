package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmTiers;
import com.yewi.yewicore.recuperation.dtos.CmmTiersDTO;
import com.yewi.yewicore.recuperation.repository.CmmTiersRepository;
import com.yewi.yewicore.recuperation.vo.CmmTiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmTiersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmTiersService {

    @Autowired
    private CmmTiersRepository cmmTiersRepository;

    public Long save(CmmTiersVO vO) {
        CmmTiers bean = new CmmTiers();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmTiersRepository.save(bean);
        return bean.getTieId();
    }

    public void delete(Long id) {
        cmmTiersRepository.deleteById(id);
    }

    public void update(Long id, CmmTiersUpdateVO vO) {
        CmmTiers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmTiersRepository.save(bean);
    }

    public CmmTiersDTO getById(Long id) {
        CmmTiers original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmTiersDTO> query(CmmTiersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmTiersDTO toDTO(CmmTiers original) {
        CmmTiersDTO bean = new CmmTiersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmTiers requireOne(Long id) {
        return cmmTiersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
