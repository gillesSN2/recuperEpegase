package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalaries;
import com.yewi.yewicore.recuperation.dtos.PaySalariesDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesService {

    @Autowired
    private PaySalariesRepository paySalariesRepository;

    public Long save(PaySalariesVO vO) {
        PaySalaries bean = new PaySalaries();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesRepository.save(bean);
        return bean.getSalId();
    }

    public void delete(Long id) {
        paySalariesRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesUpdateVO vO) {
        PaySalaries bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesRepository.save(bean);
    }

    public PaySalariesDTO getById(Long id) {
        PaySalaries original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesDTO> query(PaySalariesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesDTO toDTO(PaySalaries original) {
        PaySalariesDTO bean = new PaySalariesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalaries requireOne(Long id) {
        return paySalariesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
