package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchNoteDebitEntete;
import com.yewi.yewicore.recuperation.dtos.AchNoteDebitEnteteDTO;
import com.yewi.yewicore.recuperation.repository.AchNoteDebitEnteteRepository;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchNoteDebitEnteteService {

    @Autowired
    private AchNoteDebitEnteteRepository achNoteDebitEnteteRepository;

    public Long save(AchNoteDebitEnteteVO vO) {
        AchNoteDebitEntete bean = new AchNoteDebitEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = achNoteDebitEnteteRepository.save(bean);
        return bean.getNdfId();
    }

    public void delete(Long id) {
        achNoteDebitEnteteRepository.deleteById(id);
    }

    public void update(Long id, AchNoteDebitEnteteUpdateVO vO) {
        AchNoteDebitEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achNoteDebitEnteteRepository.save(bean);
    }

    public AchNoteDebitEnteteDTO getById(Long id) {
        AchNoteDebitEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchNoteDebitEnteteDTO> query(AchNoteDebitEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchNoteDebitEnteteDTO toDTO(AchNoteDebitEntete original) {
        AchNoteDebitEnteteDTO bean = new AchNoteDebitEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchNoteDebitEntete requireOne(Long id) {
        return achNoteDebitEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
