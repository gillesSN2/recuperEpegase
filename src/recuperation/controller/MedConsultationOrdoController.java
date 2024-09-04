package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedConsultationOrdoDTO;
import com.yewi.yewicore.recuperation.service.MedConsultationOrdoService;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationOrdoVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medConsultationOrdo")
public class MedConsultationOrdoController {

    @Autowired
    private MedConsultationOrdoService medConsultationOrdoService;

    @PostMapping
    public String save(@Valid @RequestBody MedConsultationOrdoVO vO) {
        return medConsultationOrdoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medConsultationOrdoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedConsultationOrdoUpdateVO vO) {
        medConsultationOrdoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedConsultationOrdoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medConsultationOrdoService.getById(id);
    }

    @GetMapping
    public Page<MedConsultationOrdoDTO> query(@Valid MedConsultationOrdoQueryVO vO) {
        return medConsultationOrdoService.query(vO);
    }
}
