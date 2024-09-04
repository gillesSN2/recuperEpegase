package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptAmortissementsTabDTO;
import com.yewi.yewicore.recuperation.service.CptAmortissementsTabService;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsTabVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptAmortissementsTab")
public class CptAmortissementsTabController {

    @Autowired
    private CptAmortissementsTabService cptAmortissementsTabService;

    @PostMapping
    public String save(@Valid @RequestBody CptAmortissementsTabVO vO) {
        return cptAmortissementsTabService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptAmortissementsTabService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptAmortissementsTabUpdateVO vO) {
        cptAmortissementsTabService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptAmortissementsTabDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptAmortissementsTabService.getById(id);
    }

    @GetMapping
    public Page<CptAmortissementsTabDTO> query(@Valid CptAmortissementsTabQueryVO vO) {
        return cptAmortissementsTabService.query(vO);
    }
}
