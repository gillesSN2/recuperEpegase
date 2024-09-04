package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmMailsPj;
import com.yewi.yewicore.recuperation.dtos.CmmMailsPjDTO;
import com.yewi.yewicore.recuperation.repository.CmmMailsPjRepository;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmMailsPjVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmMailsPjService {

    @Autowired
    private CmmMailsPjRepository cmmMailsPjRepository;

    public Long save(CmmMailsPjVO vO) {
        CmmMailsPj bean = new CmmMailsPj();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmMailsPjRepository.save(bean);
        return bean.getMaipjId();
    }

    public void delete(Long id) {
        cmmMailsPjRepository.deleteById(id);
    }

    public void update(Long id, CmmMailsPjUpdateVO vO) {
        CmmMailsPj bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmMailsPjRepository.save(bean);
    }

    public CmmMailsPjDTO getById(Long id) {
        CmmMailsPj original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmMailsPjDTO> query(CmmMailsPjQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmMailsPjDTO toDTO(CmmMailsPj original) {
        CmmMailsPjDTO bean = new CmmMailsPjDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmMailsPj requireOne(Long id) {
        return cmmMailsPjRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
