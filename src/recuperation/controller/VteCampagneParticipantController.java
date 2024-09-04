package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteCampagneParticipantDTO;
import com.yewi.yewicore.recuperation.service.VteCampagneParticipantService;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantQueryVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteCampagneParticipantVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteCampagneParticipant")
public class VteCampagneParticipantController {

    @Autowired
    private VteCampagneParticipantService vteCampagneParticipantService;

    @PostMapping
    public String save(@Valid @RequestBody VteCampagneParticipantVO vO) {
        return vteCampagneParticipantService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteCampagneParticipantService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteCampagneParticipantUpdateVO vO) {
        vteCampagneParticipantService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteCampagneParticipantDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteCampagneParticipantService.getById(id);
    }

    @GetMapping
    public Page<VteCampagneParticipantDTO> query(@Valid VteCampagneParticipantQueryVO vO) {
        return vteCampagneParticipantService.query(vO);
    }
}
