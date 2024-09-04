package recuperation.service;

import com.yewi.yewicore.recuperation.domain.CaiCaissesMois;
import com.yewi.yewicore.recuperation.dtos.CaiCaissesMoisDTO;
import com.yewi.yewicore.recuperation.repository.CaiCaissesMoisRepository;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisQueryVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisUpdateVO;
import com.yewi.yewicore.recuperation.vo.CaiCaissesMoisVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CaiCaissesMoisService {

    @Autowired
    private CaiCaissesMoisRepository caiCaissesMoisRepository;

    public Long save(CaiCaissesMoisVO vO) {
        CaiCaissesMois bean = new CaiCaissesMois();
        BeanUtils.copyProperties(vO, bean);
        bean = caiCaissesMoisRepository.save(bean);
        return bean.getCaimenId();
    }

    public void delete(Long id) {
        caiCaissesMoisRepository.deleteById(id);
    }

    public void update(Long id, CaiCaissesMoisUpdateVO vO) {
        CaiCaissesMois bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        caiCaissesMoisRepository.save(bean);
    }

    public CaiCaissesMoisDTO getById(Long id) {
        CaiCaissesMois original = requireOne(id);
        return toDTO(original);
    }

    public Page<CaiCaissesMoisDTO> query(CaiCaissesMoisQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CaiCaissesMoisDTO toDTO(CaiCaissesMois original) {
        CaiCaissesMoisDTO bean = new CaiCaissesMoisDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CaiCaissesMois requireOne(Long id) {
        return caiCaissesMoisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
