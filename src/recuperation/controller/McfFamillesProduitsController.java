package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.McfFamillesProduitsDTO;
import com.yewi.yewicore.recuperation.service.McfFamillesProduitsService;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsQueryVO;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsUpdateVO;
import com.yewi.yewicore.recuperation.vo.McfFamillesProduitsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/mcfFamillesProduits")
public class McfFamillesProduitsController {

    @Autowired
    private McfFamillesProduitsService mcfFamillesProduitsService;

    @PostMapping
    public String save(@Valid @RequestBody McfFamillesProduitsVO vO) {
        return mcfFamillesProduitsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        mcfFamillesProduitsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody McfFamillesProduitsUpdateVO vO) {
        mcfFamillesProduitsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public McfFamillesProduitsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return mcfFamillesProduitsService.getById(id);
    }

    @GetMapping
    public Page<McfFamillesProduitsDTO> query(@Valid McfFamillesProduitsQueryVO vO) {
        return mcfFamillesProduitsService.query(vO);
    }
}
