package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesElements;
import com.yewi.yewicore.recuperation.dtos.PaySalariesElementsDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesElementsRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesElementsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesElementsService {

    @Autowired
    private PaySalariesElementsRepository paySalariesElementsRepository;

    public Long save(PaySalariesElementsVO vO) {
        PaySalariesElements bean = new PaySalariesElements();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesElementsRepository.save(bean);
        return bean.getSaleleId();
    }

    public void delete(Long id) {
        paySalariesElementsRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesElementsUpdateVO vO) {
        PaySalariesElements bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesElementsRepository.save(bean);
    }

    public PaySalariesElementsDTO getById(Long id) {
        PaySalariesElements original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesElementsDTO> query(PaySalariesElementsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesElementsDTO toDTO(PaySalariesElements original) {
        PaySalariesElementsDTO bean = new PaySalariesElementsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesElements requireOne(Long id) {
        return paySalariesElementsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
