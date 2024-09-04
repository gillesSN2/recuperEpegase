package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesVariables;
import com.yewi.yewicore.recuperation.dtos.PaySalariesVariablesDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesVariablesRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesVariablesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesVariablesService {

    @Autowired
    private PaySalariesVariablesRepository paySalariesVariablesRepository;

    public Long save(PaySalariesVariablesVO vO) {
        PaySalariesVariables bean = new PaySalariesVariables();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesVariablesRepository.save(bean);
        return bean.getSalvarId();
    }

    public void delete(Long id) {
        paySalariesVariablesRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesVariablesUpdateVO vO) {
        PaySalariesVariables bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesVariablesRepository.save(bean);
    }

    public PaySalariesVariablesDTO getById(Long id) {
        PaySalariesVariables original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesVariablesDTO> query(PaySalariesVariablesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesVariablesDTO toDTO(PaySalariesVariables original) {
        PaySalariesVariablesDTO bean = new PaySalariesVariablesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesVariables requireOne(Long id) {
        return paySalariesVariablesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
