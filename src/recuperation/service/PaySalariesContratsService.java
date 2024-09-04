package recuperation.service;

import com.yewi.yewicore.recuperation.domain.PaySalariesContrats;
import com.yewi.yewicore.recuperation.dtos.PaySalariesContratsDTO;
import com.yewi.yewicore.recuperation.repository.PaySalariesContratsRepository;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsQueryVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsUpdateVO;
import com.yewi.yewicore.recuperation.vo.PaySalariesContratsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PaySalariesContratsService {

    @Autowired
    private PaySalariesContratsRepository paySalariesContratsRepository;

    public Long save(PaySalariesContratsVO vO) {
        PaySalariesContrats bean = new PaySalariesContrats();
        BeanUtils.copyProperties(vO, bean);
        bean = paySalariesContratsRepository.save(bean);
        return bean.getSalconId();
    }

    public void delete(Long id) {
        paySalariesContratsRepository.deleteById(id);
    }

    public void update(Long id, PaySalariesContratsUpdateVO vO) {
        PaySalariesContrats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        paySalariesContratsRepository.save(bean);
    }

    public PaySalariesContratsDTO getById(Long id) {
        PaySalariesContrats original = requireOne(id);
        return toDTO(original);
    }

    public Page<PaySalariesContratsDTO> query(PaySalariesContratsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PaySalariesContratsDTO toDTO(PaySalariesContrats original) {
        PaySalariesContratsDTO bean = new PaySalariesContratsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PaySalariesContrats requireOne(Long id) {
        return paySalariesContratsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
