package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchNoteDebitLigne;
import com.yewi.yewicore.recuperation.dtos.AchNoteDebitLigneDTO;
import com.yewi.yewicore.recuperation.repository.AchNoteDebitLigneRepository;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchNoteDebitLigneService {

    @Autowired
    private AchNoteDebitLigneRepository achNoteDebitLigneRepository;

    public Long save(AchNoteDebitLigneVO vO) {
        AchNoteDebitLigne bean = new AchNoteDebitLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = achNoteDebitLigneRepository.save(bean);
        return bean.getNdfligId();
    }

    public void delete(Long id) {
        achNoteDebitLigneRepository.deleteById(id);
    }

    public void update(Long id, AchNoteDebitLigneUpdateVO vO) {
        AchNoteDebitLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achNoteDebitLigneRepository.save(bean);
    }

    public AchNoteDebitLigneDTO getById(Long id) {
        AchNoteDebitLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchNoteDebitLigneDTO> query(AchNoteDebitLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchNoteDebitLigneDTO toDTO(AchNoteDebitLigne original) {
        AchNoteDebitLigneDTO bean = new AchNoteDebitLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchNoteDebitLigne requireOne(Long id) {
        return achNoteDebitLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
