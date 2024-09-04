package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteFormulesVentes;
import com.yewi.yewicore.recuperation.dtos.VteFormulesVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteFormulesVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteFormulesVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteFormulesVentesService {

    @Autowired
    private VteFormulesVentesRepository vteFormulesVentesRepository;

    public Long save(VteFormulesVentesVO vO) {
        VteFormulesVentes bean = new VteFormulesVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteFormulesVentesRepository.save(bean);
        return bean.getForvteId();
    }

    public void delete(Long id) {
        vteFormulesVentesRepository.deleteById(id);
    }

    public void update(Long id, VteFormulesVentesUpdateVO vO) {
        VteFormulesVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteFormulesVentesRepository.save(bean);
    }

    public VteFormulesVentesDTO getById(Long id) {
        VteFormulesVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteFormulesVentesDTO> query(VteFormulesVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteFormulesVentesDTO toDTO(VteFormulesVentes original) {
        VteFormulesVentesDTO bean = new VteFormulesVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteFormulesVentes requireOne(Long id) {
        return vteFormulesVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
