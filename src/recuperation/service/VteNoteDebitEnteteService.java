package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteNoteDebitEntete;
import com.yewi.yewicore.recuperation.dtos.VteNoteDebitEnteteDTO;
import com.yewi.yewicore.recuperation.repository.VteNoteDebitEnteteRepository;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteNoteDebitEnteteService {

    @Autowired
    private VteNoteDebitEnteteRepository vteNoteDebitEnteteRepository;

    public Long save(VteNoteDebitEnteteVO vO) {
        VteNoteDebitEntete bean = new VteNoteDebitEntete();
        BeanUtils.copyProperties(vO, bean);
        bean = vteNoteDebitEnteteRepository.save(bean);
        return bean.getNdbId();
    }

    public void delete(Long id) {
        vteNoteDebitEnteteRepository.deleteById(id);
    }

    public void update(Long id, VteNoteDebitEnteteUpdateVO vO) {
        VteNoteDebitEntete bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteNoteDebitEnteteRepository.save(bean);
    }

    public VteNoteDebitEnteteDTO getById(Long id) {
        VteNoteDebitEntete original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteNoteDebitEnteteDTO> query(VteNoteDebitEnteteQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteNoteDebitEnteteDTO toDTO(VteNoteDebitEntete original) {
        VteNoteDebitEnteteDTO bean = new VteNoteDebitEnteteDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteNoteDebitEntete requireOne(Long id) {
        return vteNoteDebitEnteteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
