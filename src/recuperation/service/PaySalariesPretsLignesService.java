package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesPretsLignes;
import com.yewi.yewicore.recuperation.dtos.PaySalariesPretsLignesDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesPretsLignesRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesPretsLignesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesPretsLignesService {

    @Autowired
    private PaySalariesPretsLignesRepository paySalariesPretsLignesRepository;

    public Long save(PaySalariesPretsLignesVO vO) {
        PaySalariesPretsLignes bean = new PaySalariesPretsLignes();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesPretsLignesRepository.save(bean);
        return bean.getSalpreligId();
    }

    public void delete(Long id) {
        paySalariesPretsLignesRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesPretsLignesUpdateVO vO) {
        PaySalariesPretsLignes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesPretsLignesRepository.save(bean);
    }

    public PaySalariesPretsLignesDTO getById(Long id) {
        PaySalariesPretsLignes original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesPretsLignesDTO> query(PaySalariesPretsLignesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesPretsLignesDTO toDTO(PaySalariesPretsLignes original) {
        PaySalariesPretsLignesDTO bean = new PaySalariesPretsLignesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesPretsLignes requireOne(Long id) {
        return paySalariesPretsLignesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
