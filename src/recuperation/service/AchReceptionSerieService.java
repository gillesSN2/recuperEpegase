package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchReceptionSerie;
import com.yewi.yewicore.recuperation.dtos.AchReceptionSerieDTO;
import com.yewi.yewicore.recuperation.repository.AchReceptionSerieRepository;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionSerieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchReceptionSerieService {

    @Autowired
    private AchReceptionSerieRepository achReceptionSerieRepository;

    public Long save(AchReceptionSerieVO vO) {
        AchReceptionSerie bean = new AchReceptionSerie();
        BeanUtils.copyProperties(vO, bean);
        bean = achReceptionSerieRepository.save(bean);
        return bean.getRecserId();
    }

    public void delete(Long id) {
        achReceptionSerieRepository.deleteById(id);
    }

    public void update(Long id, AchReceptionSerieUpdateVO vO) {
        AchReceptionSerie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achReceptionSerieRepository.save(bean);
    }

    public AchReceptionSerieDTO getById(Long id) {
        AchReceptionSerie original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchReceptionSerieDTO> query(AchReceptionSerieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchReceptionSerieDTO toDTO(AchReceptionSerie original) {
        AchReceptionSerieDTO bean = new AchReceptionSerieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchReceptionSerie requireOne(Long id) {
        return achReceptionSerieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
