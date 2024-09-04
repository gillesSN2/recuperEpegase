package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedSpecialitesMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedSpecialitesMedicalService;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedSpecialitesMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medSpecialitesMedical")
public class MedSpecialitesMedicalController {

    @Autowired
    private MedSpecialitesMedicalService medSpecialitesMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedSpecialitesMedicalVO vO) {
        return medSpecialitesMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medSpecialitesMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedSpecialitesMedicalUpdateVO vO) {
        medSpecialitesMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedSpecialitesMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medSpecialitesMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedSpecialitesMedicalDTO> query(@Valid MedSpecialitesMedicalQueryVO vO) {
        return medSpecialitesMedicalService.query(vO);
    }
}
