package recuperation.service;

import com.yewi.yewicore.recuperation.domain.McfExercicesMicrofinance;
import com.yewi.yewicore.recuperation.dtos.McfExercicesMicrofinanceDTO;
import com.yewi.yewicore.recuperation.repository.McfExercicesMicrofinanceRepository;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceQueryVO;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfExercicesMicrofinanceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class McfExercicesMicrofinanceService {

    @Autowired
    private McfExercicesMicrofinanceRepository mcfExercicesMicrofinanceRepository;

    public Long save(McfExercicesMicrofinanceVO vO) {
        McfExercicesMicrofinance bean = new McfExercicesMicrofinance();
        BeanUtils.copyProperties(vO, bean);
        bean = mcfExercicesMicrofinanceRepository.save(bean);
        return bean.getExemcfId();
    }

    public void delete(Long id) {
        mcfExercicesMicrofinanceRepository.deleteById(id);
    }

    public void update(Long id, McfExercicesMicrofinanceUpdateVO vO) {
        McfExercicesMicrofinance bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        mcfExercicesMicrofinanceRepository.save(bean);
    }

    public McfExercicesMicrofinanceDTO getById(Long id) {
        McfExercicesMicrofinance original = requireOne(id);
        return toDTO(original);
    }

    public Page<McfExercicesMicrofinanceDTO> query(McfExercicesMicrofinanceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private McfExercicesMicrofinanceDTO toDTO(McfExercicesMicrofinance original) {
        McfExercicesMicrofinanceDTO bean = new McfExercicesMicrofinanceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private McfExercicesMicrofinance requireOne(Long id) {
        return mcfExercicesMicrofinanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
