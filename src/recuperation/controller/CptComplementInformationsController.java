package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptComplementInformationsDTO;
import com.yewi.yewicore.recuperation.service.CptComplementInformationsService;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptComplementInformationsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptComplementInformations")
public class CptComplementInformationsController {

    @Autowired
    private CptComplementInformationsService cptComplementInformationsService;

    @PostMapping
    public String save(@Valid @RequestBody CptComplementInformationsVO vO) {
        return cptComplementInformationsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptComplementInformationsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptComplementInformationsUpdateVO vO) {
        cptComplementInformationsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptComplementInformationsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptComplementInformationsService.getById(id);
    }

    @GetMapping
    public Page<CptComplementInformationsDTO> query(@Valid CptComplementInformationsQueryVO vO) {
        return cptComplementInformationsService.query(vO);
    }
}
