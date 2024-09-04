package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteDocumentTraceVentes;
import com.yewi.yewicore.recuperation.dtos.VteDocumentTraceVentesDTO;
import com.yewi.yewicore.recuperation.repository.VteDocumentTraceVentesRepository;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDocumentTraceVentesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteDocumentTraceVentesService {

    @Autowired
    private VteDocumentTraceVentesRepository vteDocumentTraceVentesRepository;

    public Long save(VteDocumentTraceVentesVO vO) {
        VteDocumentTraceVentes bean = new VteDocumentTraceVentes();
        BeanUtils.copyProperties(vO, bean);
        bean = vteDocumentTraceVentesRepository.save(bean);
        return bean.getDoctraId();
    }

    public void delete(Long id) {
        vteDocumentTraceVentesRepository.deleteById(id);
    }

    public void update(Long id, VteDocumentTraceVentesUpdateVO vO) {
        VteDocumentTraceVentes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteDocumentTraceVentesRepository.save(bean);
    }

    public VteDocumentTraceVentesDTO getById(Long id) {
        VteDocumentTraceVentes original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteDocumentTraceVentesDTO> query(VteDocumentTraceVentesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteDocumentTraceVentesDTO toDTO(VteDocumentTraceVentes original) {
        VteDocumentTraceVentesDTO bean = new VteDocumentTraceVentesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteDocumentTraceVentes requireOne(Long id) {
        return vteDocumentTraceVentesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
