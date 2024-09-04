package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedPharmacieLigne;
import com.yewi.yewicore.recuperation.dtos.MedPharmacieLigneDTO;
import com.yewi.yewicore.recuperation.repository.MedPharmacieLigneRepository;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPharmacieLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedPharmacieLigneService {

    @Autowired
    private MedPharmacieLigneRepository medPharmacieLigneRepository;

    public Long save(MedPharmacieLigneVO vO) {
        MedPharmacieLigne bean = new MedPharmacieLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = medPharmacieLigneRepository.save(bean);
        return bean.getPhaligId();
    }

    public void delete(Long id) {
        medPharmacieLigneRepository.deleteById(id);
    }

    public void update(Long id, MedPharmacieLigneUpdateVO vO) {
        MedPharmacieLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medPharmacieLigneRepository.save(bean);
    }

    public MedPharmacieLigneDTO getById(Long id) {
        MedPharmacieLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedPharmacieLigneDTO> query(MedPharmacieLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedPharmacieLigneDTO toDTO(MedPharmacieLigne original) {
        MedPharmacieLigneDTO bean = new MedPharmacieLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedPharmacieLigne requireOne(Long id) {
        return medPharmacieLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
