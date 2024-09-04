package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedConsultationLaboDTO;
import com.yewi.yewicore.recuperation.service.MedConsultationLaboService;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationLaboVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medConsultationLabo")
public class MedConsultationLaboController {

    @Autowired
    private MedConsultationLaboService medConsultationLaboService;

    @PostMapping
    public String save(@Valid @RequestBody MedConsultationLaboVO vO) {
        return medConsultationLaboService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medConsultationLaboService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedConsultationLaboUpdateVO vO) {
        medConsultationLaboService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedConsultationLaboDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medConsultationLaboService.getById(id);
    }

    @GetMapping
    public Page<MedConsultationLaboDTO> query(@Valid MedConsultationLaboQueryVO vO) {
        return medConsultationLaboService.query(vO);
    }
}
