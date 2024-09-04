package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmMetiers;
import com.yewi.yewicore.recuperation.dtos.CmmMetiersDTO;
import com.yewi.yewicore.recuperation.repository.CmmMetiersRepository;
import com.yewi.yewicore.recuperation.vo.CmmMetiersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMetiersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMetiersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmMetiersService {

    @Autowired
    private CmmMetiersRepository cmmMetiersRepository;

    public Long save(CmmMetiersVO vO) {
        CmmMetiers bean = new CmmMetiers();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmMetiersRepository.save(bean);
        return bean.getMetId();
    }

    public void delete(Long id) {
        cmmMetiersRepository.deleteById(id);
    }

    public void update(Long id, CmmMetiersUpdateVO vO) {
        CmmMetiers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmMetiersRepository.save(bean);
    }

    public CmmMetiersDTO getById(Long id) {
        CmmMetiers original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmMetiersDTO> query(CmmMetiersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmMetiersDTO toDTO(CmmMetiers original) {
        CmmMetiersDTO bean = new CmmMetiersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmMetiers requireOne(Long id) {
        return cmmMetiersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
