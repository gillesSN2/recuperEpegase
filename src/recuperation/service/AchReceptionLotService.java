package recuperation.service;

import com.yewi.yewicore.recuperation.domain.AchReceptionLot;
import com.yewi.yewicore.recuperation.dtos.AchReceptionLotDTO;
import com.yewi.yewicore.recuperation.repository.AchReceptionLotRepository;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotQueryVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchReceptionLotVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AchReceptionLotService {

    @Autowired
    private AchReceptionLotRepository achReceptionLotRepository;

    public Long save(AchReceptionLotVO vO) {
        AchReceptionLot bean = new AchReceptionLot();
        BeanUtils.copyProperties(vO, bean);
        bean = achReceptionLotRepository.save(bean);
        return bean.getReclotId();
    }

    public void delete(Long id) {
        achReceptionLotRepository.deleteById(id);
    }

    public void update(Long id, AchReceptionLotUpdateVO vO) {
        AchReceptionLot bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        achReceptionLotRepository.save(bean);
    }

    public AchReceptionLotDTO getById(Long id) {
        AchReceptionLot original = requireOne(id);
        return toDTO(original);
    }

    public Page<AchReceptionLotDTO> query(AchReceptionLotQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AchReceptionLotDTO toDTO(AchReceptionLot original) {
        AchReceptionLotDTO bean = new AchReceptionLotDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private AchReceptionLot requireOne(Long id) {
        return achReceptionLotRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
