package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienTravauxLigne;
import com.yewi.yewicore.recuperation.dtos.ImmBienTravauxLigneDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienTravauxLigneRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienTravauxLigneVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienTravauxLigneService {

    @Autowired
    private ImmBienTravauxLigneRepository immBienTravauxLigneRepository;

    public Long save(ImmBienTravauxLigneVO vO) {
        ImmBienTravauxLigne bean = new ImmBienTravauxLigne();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienTravauxLigneRepository.save(bean);
        return bean.getBietraligId();
    }

    public void delete(Long id) {
        immBienTravauxLigneRepository.deleteById(id);
    }

    public void update(Long id, ImmBienTravauxLigneUpdateVO vO) {
        ImmBienTravauxLigne bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienTravauxLigneRepository.save(bean);
    }

    public ImmBienTravauxLigneDTO getById(Long id) {
        ImmBienTravauxLigne original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienTravauxLigneDTO> query(ImmBienTravauxLigneQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienTravauxLigneDTO toDTO(ImmBienTravauxLigne original) {
        ImmBienTravauxLigneDTO bean = new ImmBienTravauxLigneDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienTravauxLigne requireOne(Long id) {
        return immBienTravauxLigneRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
