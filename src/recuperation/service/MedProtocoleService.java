package recuperation.service;

import com.yewi.yewicore.recuperation.domain.MedProtocole;
import com.yewi.yewicore.recuperation.dtos.MedProtocoleDTO;
import com.yewi.yewicore.recuperation.repository.MedProtocoleRepository;
import com.yewi.yewicore.recuperation.vo.MedProtocoleQueryVO;
import com.yewi.yewicore.recuperation.vo.MedProtocoleUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedProtocoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MedProtocoleService {

    @Autowired
    private MedProtocoleRepository medProtocoleRepository;

    public Long save(MedProtocoleVO vO) {
        MedProtocole bean = new MedProtocole();
        BeanUtils.copyProperties(vO, bean);
        bean = medProtocoleRepository.save(bean);
        return bean.getPrtId();
    }

    public void delete(Long id) {
        medProtocoleRepository.deleteById(id);
    }

    public void update(Long id, MedProtocoleUpdateVO vO) {
        MedProtocole bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        medProtocoleRepository.save(bean);
    }

    public MedProtocoleDTO getById(Long id) {
        MedProtocole original = requireOne(id);
        return toDTO(original);
    }

    public Page<MedProtocoleDTO> query(MedProtocoleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MedProtocoleDTO toDTO(MedProtocole original) {
        MedProtocoleDTO bean = new MedProtocoleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MedProtocole requireOne(Long id) {
        return medProtocoleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
