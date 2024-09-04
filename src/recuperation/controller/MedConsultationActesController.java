package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedConsultationActesDTO;
import com.yewi.yewicore.recuperation.service.MedConsultationActesService;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationActesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medConsultationActes")
public class MedConsultationActesController {

    @Autowired
    private MedConsultationActesService medConsultationActesService;

    @PostMapping
    public String save(@Valid @RequestBody MedConsultationActesVO vO) {
        return medConsultationActesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medConsultationActesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedConsultationActesUpdateVO vO) {
        medConsultationActesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedConsultationActesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medConsultationActesService.getById(id);
    }

    @GetMapping
    public Page<MedConsultationActesDTO> query(@Valid MedConsultationActesQueryVO vO) {
        return medConsultationActesService.query(vO);
    }
}
