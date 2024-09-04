package recuperation.service;

import com.yewi.yewicore.recuperation.domain.ImmBienFacture;
import com.yewi.yewicore.recuperation.dtos.ImmBienFactureDTO;
import com.yewi.yewicore.recuperation.repository.ImmBienFactureRepository;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureQueryVO;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureUpdateVO;
import com.yewi.yewicore.recuperation.vo.ImmBienFactureVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ImmBienFactureService {

    @Autowired
    private ImmBienFactureRepository immBienFactureRepository;

    public Long save(ImmBienFactureVO vO) {
        ImmBienFacture bean = new ImmBienFacture();
        BeanUtils.copyProperties(vO, bean);
        bean = immBienFactureRepository.save(bean);
        return bean.getBiefacId();
    }

    public void delete(Long id) {
        immBienFactureRepository.deleteById(id);
    }

    public void update(Long id, ImmBienFactureUpdateVO vO) {
        ImmBienFacture bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        immBienFactureRepository.save(bean);
    }

    public ImmBienFactureDTO getById(Long id) {
        ImmBienFacture original = requireOne(id);
        return toDTO(original);
    }

    public Page<ImmBienFactureDTO> query(ImmBienFactureQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ImmBienFactureDTO toDTO(ImmBienFacture original) {
        ImmBienFactureDTO bean = new ImmBienFactureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ImmBienFacture requireOne(Long id) {
        return immBienFactureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
