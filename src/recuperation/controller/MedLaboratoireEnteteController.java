package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedLaboratoireEnteteDTO;
import com.yewi.yewicore.recuperation.service.MedLaboratoireEnteteService;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLaboratoireEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medLaboratoireEntete")
public class MedLaboratoireEnteteController {

    @Autowired
    private MedLaboratoireEnteteService medLaboratoireEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody MedLaboratoireEnteteVO vO) {
        return medLaboratoireEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medLaboratoireEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedLaboratoireEnteteUpdateVO vO) {
        medLaboratoireEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedLaboratoireEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medLaboratoireEnteteService.getById(id);
    }

    @GetMapping
    public Page<MedLaboratoireEnteteDTO> query(@Valid MedLaboratoireEnteteQueryVO vO) {
        return medLaboratoireEnteteService.query(vO);
    }
}
