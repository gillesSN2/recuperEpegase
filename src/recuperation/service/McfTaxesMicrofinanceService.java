package recuperation.service;

import com.yewi.yewicore.recuperation.domain.McfTaxesMicrofinance;
import com.yewi.yewicore.recuperation.dtos.McfTaxesMicrofinanceDTO;
import com.yewi.yewicore.recuperation.repository.McfTaxesMicrofinanceRepository;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceQueryVO;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfTaxesMicrofinanceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class McfTaxesMicrofinanceService {

    @Autowired
    private McfTaxesMicrofinanceRepository mcfTaxesMicrofinanceRepository;

    public Long save(McfTaxesMicrofinanceVO vO) {
        McfTaxesMicrofinance bean = new McfTaxesMicrofinance();
        BeanUtils.copyProperties(vO, bean);
        bean = mcfTaxesMicrofinanceRepository.save(bean);
        return bean.getTaxmcfId();
    }

    public void delete(Long id) {
        mcfTaxesMicrofinanceRepository.deleteById(id);
    }

    public void update(Long id, McfTaxesMicrofinanceUpdateVO vO) {
        McfTaxesMicrofinance bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        mcfTaxesMicrofinanceRepository.save(bean);
    }

    public McfTaxesMicrofinanceDTO getById(Long id) {
        McfTaxesMicrofinance original = requireOne(id);
        return toDTO(original);
    }

    public Page<McfTaxesMicrofinanceDTO> query(McfTaxesMicrofinanceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private McfTaxesMicrofinanceDTO toDTO(McfTaxesMicrofinance original) {
        McfTaxesMicrofinanceDTO bean = new McfTaxesMicrofinanceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private McfTaxesMicrofinance requireOne(Long id) {
        return mcfTaxesMicrofinanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
