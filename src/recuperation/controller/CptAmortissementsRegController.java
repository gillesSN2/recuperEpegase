package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptAmortissementsRegDTO;
import com.yewi.yewicore.recuperation.service.CptAmortissementsRegService;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsRegVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptAmortissementsReg")
public class CptAmortissementsRegController {

    @Autowired
    private CptAmortissementsRegService cptAmortissementsRegService;

    @PostMapping
    public String save(@Valid @RequestBody CptAmortissementsRegVO vO) {
        return cptAmortissementsRegService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptAmortissementsRegService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptAmortissementsRegUpdateVO vO) {
        cptAmortissementsRegService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptAmortissementsRegDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptAmortissementsRegService.getById(id);
    }

    @GetMapping
    public Page<CptAmortissementsRegDTO> query(@Valid CptAmortissementsRegQueryVO vO) {
        return cptAmortissementsRegService.query(vO);
    }
}
