package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmModeleCourriers;
import com.yewi.yewicore.recuperation.dtos.CmmModeleCourriersDTO;
import com.yewi.yewicore.recuperation.repository.CmmModeleCourriersRepository;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmModeleCourriersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmModeleCourriersService {

    @Autowired
    private CmmModeleCourriersRepository cmmModeleCourriersRepository;

    public Long save(CmmModeleCourriersVO vO) {
        CmmModeleCourriers bean = new CmmModeleCourriers();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmModeleCourriersRepository.save(bean);
        return bean.getModId();
    }

    public void delete(Long id) {
        cmmModeleCourriersRepository.deleteById(id);
    }

    public void update(Long id, CmmModeleCourriersUpdateVO vO) {
        CmmModeleCourriers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmModeleCourriersRepository.save(bean);
    }

    public CmmModeleCourriersDTO getById(Long id) {
        CmmModeleCourriers original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmModeleCourriersDTO> query(CmmModeleCourriersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmModeleCourriersDTO toDTO(CmmModeleCourriers original) {
        CmmModeleCourriersDTO bean = new CmmModeleCourriersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmModeleCourriers requireOne(Long id) {
        return cmmModeleCourriersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
