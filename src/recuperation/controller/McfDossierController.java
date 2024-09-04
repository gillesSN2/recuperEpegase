package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.McfDossierDTO;
import com.yewi.yewicore.recuperation.service.McfDossierService;
import com.yewi.yewicore.recuperation.vo.McfDossierQueryVO;
import com.yewi.yewicore.recuperation.vo.McfDossierUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfDossierVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/mcfDossier")
public class McfDossierController {

    @Autowired
    private McfDossierService mcfDossierService;

    @PostMapping
    public String save(@Valid @RequestBody McfDossierVO vO) {
        return mcfDossierService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        mcfDossierService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody McfDossierUpdateVO vO) {
        mcfDossierService.update(id, vO);
    }

    @GetMapping("/{id}")
    public McfDossierDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return mcfDossierService.getById(id);
    }

    @GetMapping
    public Page<McfDossierDTO> query(@Valid McfDossierQueryVO vO) {
        return mcfDossierService.query(vO);
    }
}
