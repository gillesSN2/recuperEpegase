package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmBal;
import com.yewi.yewicore.recuperation.dtos.CmmBalDTO;
import com.yewi.yewicore.recuperation.repository.CmmBalRepository;
import com.yewi.yewicore.recuperation.vo.CmmBalQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmBalUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmBalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmBalService {

    @Autowired
    private CmmBalRepository cmmBalRepository;

    public Long save(CmmBalVO vO) {
        CmmBal bean = new CmmBal();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmBalRepository.save(bean);
        return bean.getBalId();
    }

    public void delete(Long id) {
        cmmBalRepository.deleteById(id);
    }

    public void update(Long id, CmmBalUpdateVO vO) {
        CmmBal bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmBalRepository.save(bean);
    }

    public CmmBalDTO getById(Long id) {
        CmmBal original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmBalDTO> query(CmmBalQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmBalDTO toDTO(CmmBal original) {
        CmmBalDTO bean = new CmmBalDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmBal requireOne(Long id) {
        return cmmBalRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
