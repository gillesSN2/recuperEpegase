package recuperation.service;

import com.yewi.yewicore.recuperation.domain.VteNoteDebitLigne;
import com.yewi.yewicore.recuperation.dtos.VteNoteDebitLigneDTO;
import com.yewi.yewicore.recuperation.repository.VteNoteDebitLigneRepository;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VteNoteDebitLigneService {

    @Autowired
    private VteNoteDebitLigneRepository vteNoteDebitLigneRepository;

    public Long save(VteNoteDebitLigneVO vO) {
        VteNoteDebitLigne bean = new VteNoteDebitLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = vteNoteDebitLigneRepository.save(bean);
        return bean.getNdbligId();
    }

    public void delete(Long id) {
        vteNoteDebitLigneRepository.deleteById(id);
    }

    public void update(Long id, VteNoteDebitLigneUpdateVO vO) {
        VteNoteDebitLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        vteNoteDebitLigneRepository.save(bean);
    }

    public VteNoteDebitLigneDTO getById(Long id) {
        VteNoteDebitLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<VteNoteDebitLigneDTO> query(VteNoteDebitLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private VteNoteDebitLigneDTO toDTO(VteNoteDebitLigne original) {
        VteNoteDebitLigneDTO bean = new VteNoteDebitLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private VteNoteDebitLigne requireOne(Long id) {
        return vteNoteDebitLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
