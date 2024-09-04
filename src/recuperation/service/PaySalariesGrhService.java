package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesGrh;
import com.yewi.yewicore.recuperation.dtos.PaySalariesGrhDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesGrhRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesGrhVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesGrhService {

    @Autowired
    private PaySalariesGrhRepository paySalariesGrhRepository;

    public Long save(PaySalariesGrhVO vO) {
        PaySalariesGrh bean = new PaySalariesGrh();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesGrhRepository.save(bean);
        return bean.getSalgrhId();
    }

    public void delete(Long id) {
        paySalariesGrhRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesGrhUpdateVO vO) {
        PaySalariesGrh bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesGrhRepository.save(bean);
    }

    public PaySalariesGrhDTO getById(Long id) {
        PaySalariesGrh original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesGrhDTO> query(PaySalariesGrhQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesGrhDTO toDTO(PaySalariesGrh original) {
        PaySalariesGrhDTO bean = new PaySalariesGrhDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesGrh requireOne(Long id) {
        return paySalariesGrhRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
