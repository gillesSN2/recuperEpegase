package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchDocumentTraceAchats;
import com.yewi.yewicore.recuperation.dtos.AchDocumentTraceAchatsDTO;
import com.yewi.yewicore.recuperation.repository.AchDocumentTraceAchatsRepository;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchDocumentTraceAchatsService {

    @Autowired
    private AchDocumentTraceAchatsRepository achDocumentTraceAchatsRepository;

    public Long save(AchDocumentTraceAchatsVO vO) {
        AchDocumentTraceAchats bean = new AchDocumentTraceAchats();
        BeanUtils.copyProperties(vO, bean);
        bean = achDocumentTraceAchatsRepository.save(bean);
        return bean.getDoctrfId();
    }

    public void delete(Long id) {
        achDocumentTraceAchatsRepository.deleteById(id);
    }

    public void update(Long id, AchDocumentTraceAchatsUpdateVO vO) {
        AchDocumentTraceAchats bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achDocumentTraceAchatsRepository.save(bean);
    }

    public AchDocumentTraceAchatsDTO getById(Long id) {
        AchDocumentTraceAchats original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchDocumentTraceAchatsDTO> query(AchDocumentTraceAchatsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchDocumentTraceAchatsDTO toDTO(AchDocumentTraceAchats original) {
        AchDocumentTraceAchatsDTO bean = new AchDocumentTraceAchatsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchDocumentTraceAchats requireOne(Long id) {
        return achDocumentTraceAchatsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
