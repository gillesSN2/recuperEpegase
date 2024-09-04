package recuperation.service;

import com.yewi.yewicore.recuperation.domain.EduEleves;
import com.yewi.yewicore.recuperation.dtos.EduElevesDTO;
import com.yewi.yewicore.recuperation.repository.EduElevesRepository;
import com.yewi.yewicore.recuperation.vo.EduElevesQueryVO;
import com.yewi.yewicore.recuperation.vo.EduElevesUpdateVO;
import com.yewi.yewicore.recuperation.vo.EduElevesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EduElevesService {

    @Autowired
    private EduElevesRepository eduElevesRepository;

    public Long save(EduElevesVO vO) {
        EduEleves bean = new EduEleves();
        BeanUtils.copyProperties(vO, bean);
        bean = eduElevesRepository.save(bean);
        return bean.getEleId();
    }

    public void delete(Long id) {
        eduElevesRepository.deleteById(id);
    }

    public void update(Long id, EduElevesUpdateVO vO) {
        EduEleves bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        eduElevesRepository.save(bean);
    }

    public EduElevesDTO getById(Long id) {
        EduEleves original = requireOne(id);
        return toDTO(original);
    }

    public Page<EduElevesDTO> query(EduElevesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private EduElevesDTO toDTO(EduEleves original) {
        EduElevesDTO bean = new EduElevesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private EduEleves requireOne(Long id) {
        return eduElevesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
