package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.CptAmortissementsDTO;
import com.yewi.yewicore.recuperation.service.CptAmortissementsService;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsQueryVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsUpdateVO;
import com.yewi.yewicore.recuperation.vo.CptAmortissementsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cptAmortissements")
public class CptAmortissementsController {

    @Autowired
    private CptAmortissementsService cptAmortissementsService;

    @PostMapping
    public String save(@Valid @RequestBody CptAmortissementsVO vO) {
        return cptAmortissementsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        cptAmortissementsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody CptAmortissementsUpdateVO vO) {
        cptAmortissementsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CptAmortissementsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return cptAmortissementsService.getById(id);
    }

    @GetMapping
    public Page<CptAmortissementsDTO> query(@Valid CptAmortissementsQueryVO vO) {
        return cptAmortissementsService.query(vO);
    }
}
