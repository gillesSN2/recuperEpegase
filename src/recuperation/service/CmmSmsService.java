package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CmmSms;
import com.yewi.yewicore.recuperation.dtos.CmmSmsDTO;
import com.yewi.yewicore.recuperation.repository.CmmSmsRepository;
import com.yewi.yewicore.recuperation.vo.CmmSmsQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmSmsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmSmsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CmmSmsService {

    @Autowired
    private CmmSmsRepository cmmSmsRepository;

    public Long save(CmmSmsVO vO) {
        CmmSms bean = new CmmSms();
        BeanUtils.copyProperties(vO, bean);
        bean = cmmSmsRepository.save(bean);
        return bean.getSmsId();
    }

    public void delete(Long id) {
        cmmSmsRepository.deleteById(id);
    }

    public void update(Long id, CmmSmsUpdateVO vO) {
        CmmSms bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cmmSmsRepository.save(bean);
    }

    public CmmSmsDTO getById(Long id) {
        CmmSms original = requireOne(id);
        return toDTO(original);
    }

    public Page<CmmSmsDTO> query(CmmSmsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CmmSmsDTO toDTO(CmmSms original) {
        CmmSmsDTO bean = new CmmSmsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CmmSms requireOne(Long id) {
        return cmmSmsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
