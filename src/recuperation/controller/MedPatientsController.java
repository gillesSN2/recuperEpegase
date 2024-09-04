package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPatientsDTO;
import com.yewi.yewicore.recuperation.service.MedPatientsService;
import com.yewi.yewicore.recuperation.vo.MedPatientsQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPatientsUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPatientsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPatients")
public class MedPatientsController {

    @Autowired
    private MedPatientsService medPatientsService;

    @PostMapping
    public String save(@Valid @RequestBody MedPatientsVO vO) {
        return medPatientsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPatientsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPatientsUpdateVO vO) {
        medPatientsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPatientsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPatientsService.getById(id);
    }

    @GetMapping
    public Page<MedPatientsDTO> query(@Valid MedPatientsQueryVO vO) {
        return medPatientsService.query(vO);
    }
}
