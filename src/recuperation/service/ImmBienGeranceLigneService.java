package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienGeranceLigne;
import com.yewi.yewicore.recuperation.dtos.ImmBienGeranceLigneDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienGeranceLigneRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienGeranceLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienGeranceLigneService {

    @Autowired
    private ImmBienGeranceLigneRepository immBienGeranceLigneRepository;

    public Long save(ImmBienGeranceLigneVO vO) {
        ImmBienGeranceLigne bean = new ImmBienGeranceLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienGeranceLigneRepository.save(bean);
        return bean.getBiegerligId();
    }

    public void delete(Long id) {
        immBienGeranceLigneRepository.deleteById(id);
    }

    public void update(Long id, ImmBienGeranceLigneUpdateVO vO) {
        ImmBienGeranceLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienGeranceLigneRepository.save(bean);
    }

    public ImmBienGeranceLigneDTO getById(Long id) {
        ImmBienGeranceLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienGeranceLigneDTO> query(ImmBienGeranceLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienGeranceLigneDTO toDTO(ImmBienGeranceLigne original) {
        ImmBienGeranceLigneDTO bean = new ImmBienGeranceLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienGeranceLigne requireOne(Long id) {
        return immBienGeranceLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
