package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedConsultationEnteteGeneDTO;
import com.yewi.yewicore.recuperation.service.MedConsultationEnteteGeneService;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneQueryVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedConsultationEnteteGeneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medConsultationEnteteGene")
public class MedConsultationEnteteGeneController {

    @Autowired
    private MedConsultationEnteteGeneService medConsultationEnteteGeneService;

    @PostMapping
    public String save(@Valid @RequestBody MedConsultationEnteteGeneVO vO) {
        return medConsultationEnteteGeneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medConsultationEnteteGeneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedConsultationEnteteGeneUpdateVO vO) {
        medConsultationEnteteGeneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedConsultationEnteteGeneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medConsultationEnteteGeneService.getById(id);
    }

    @GetMapping
    public Page<MedConsultationEnteteGeneDTO> query(@Valid MedConsultationEnteteGeneQueryVO vO) {
        return medConsultationEnteteGeneService.query(vO);
    }
}
