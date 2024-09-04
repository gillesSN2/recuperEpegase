package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiReglements;
import com.yewi.yewicore.recuperation.dtos.CaiReglementsDTO;
import com.yewi.yewicore.recuperation.repository.CaiReglementsRepository;
import com.yewi.yewicore.recuperation.vo.CaiReglementsQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiReglementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiReglementsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiReglementsService {

    @Autowired
    private CaiReglementsRepository caiReglementsRepository;

    public Long save(CaiReglementsVO vO) {
        CaiReglements bean = new CaiReglements();
        BeanUtils.copyProperties(vO, bean);
        bean = caiReglementsRepository.save(bean);
        return bean.getRglId();
    }

    public void delete(Long id) {
        caiReglementsRepository.deleteById(id);
    }

    public void update(Long id, CaiReglementsUpdateVO vO) {
        CaiReglements bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiReglementsRepository.save(bean);
    }

    public CaiReglementsDTO getById(Long id) {
        CaiReglements original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiReglementsDTO> query(CaiReglementsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiReglementsDTO toDTO(CaiReglements original) {
        CaiReglementsDTO bean = new CaiReglementsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiReglements requireOne(Long id) {
        return caiReglementsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
