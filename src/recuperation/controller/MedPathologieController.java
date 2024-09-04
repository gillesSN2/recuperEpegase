package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.MedPathologieDTO;
import com.yewi.yewicore.recuperation.service.MedPathologieService;
import com.yewi.yewicore.recuperation.vo.MedPathologieQueryVO;
import com.yewi.yewicore.recuperation.vo.MedPathologieUpdateVO;
import com.yewi.yewicore.recuperation.vo.MedPathologieVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medPathologie")
public class MedPathologieController {

    @Autowired
    private MedPathologieService medPathologieService;

    @PostMapping
    public String save(@Valid @RequestBody MedPathologieVO vO) {
        return medPathologieService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        medPathologieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody MedPathologieUpdateVO vO) {
        medPathologieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MedPathologieDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return medPathologieService.getById(id);
    }

    @GetMapping
    public Page<MedPathologieDTO> query(@Valid MedPathologieQueryVO vO) {
        return medPathologieService.query(vO);
    }
}
