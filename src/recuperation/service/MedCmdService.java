package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedCmd;
import com.yewi.yewicore.recuperation.dtos.MedCmdDTO;
import com.yewi.yewicore.recuperation.repository.MedCmdRepository;
import com.yewi.yewicore.recuperation.vo.MedCmdQueryVO;
import com.yewi.yewicore.recuperation.vo.MedCmdUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedCmdVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedCmdService {

    @Autowired
    private MedCmdRepository medCmdRepository;

    public Long save(MedCmdVO vO) {
        MedCmd bean = new MedCmd();
        BeanUtils.copyProperties(vO, bean);
        bean = medCmdRepository.save(bean);
        return bean.getCmdId();
    }

    public void delete(Long id) {
        medCmdRepository.deleteById(id);
    }

    public void update(Long id, MedCmdUpdateVO vO) {
        MedCmd bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medCmdRepository.save(bean);
    }

    public MedCmdDTO getById(Long id) {
        MedCmd original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedCmdDTO> query(MedCmdQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedCmdDTO toDTO(MedCmd original) {
        MedCmdDTO bean = new MedCmdDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedCmd requireOne(Long id) {
        return medCmdRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
