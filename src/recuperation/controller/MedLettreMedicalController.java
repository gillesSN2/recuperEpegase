package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedLettreMedicalDTO;
import com.yewi.yewicore.recuperation.service.MedLettreMedicalService;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalQueryVO;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedLettreMedicalVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medLettreMedical")
public class MedLettreMedicalController {

    @Autowired
    private MedLettreMedicalService medLettreMedicalService;

    @PostMapping
    public String save(@Valid @RequestBody MedLettreMedicalVO vO) {
        return medLettreMedicalService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medLettreMedicalService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedLettreMedicalUpdateVO vO) {
        medLettreMedicalService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedLettreMedicalDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medLettreMedicalService.getById(id);
    }

    @GetMapping
    public Page<MedLettreMedicalDTO> query(@Valid MedLettreMedicalQueryVO vO) {
        return medLettreMedicalService.query(vO);
    }
}
