package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CmmProduitsLaboratoireDTO;
import com.yewi.yewicore.recuperation.service.CmmProduitsLaboratoireService;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireQueryVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireUpdateVO;
import com.yewi.yewicore.recuperation.vo.CmmProduitsLaboratoireVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cmmProduitsLaboratoire")
public class CmmProduitsLaboratoireController {

    @Autowired
    private CmmProduitsLaboratoireService cmmProduitsLaboratoireService;

    @PostMapping
    public String save(@Valid @RequestBody CmmProduitsLaboratoireVO vO) {
        return cmmProduitsLaboratoireService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cmmProduitsLaboratoireService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CmmProduitsLaboratoireUpdateVO vO) {
        cmmProduitsLaboratoireService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CmmProduitsLaboratoireDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cmmProduitsLaboratoireService.getById(id);
    }

    @GetMapping
    public Page<CmmProduitsLaboratoireDTO> query(@Valid CmmProduitsLaboratoireQueryVO vO) {
        return cmmProduitsLaboratoireService.query(vO);
    }
}
