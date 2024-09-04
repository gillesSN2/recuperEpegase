package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.FamillesFournisseursDTO;
import com.yewi.yewicore.recuperation.service.FamillesFournisseursService;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursQueryVO;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursUpdateVO;
import com.yewi.yewicore.recuperation.vo.FamillesFournisseursVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/famillesFournisseurs")
public class FamillesFournisseursController {

    @Autowired
    private FamillesFournisseursService famillesFournisseursService;

    @PostMapping
    public String save(@Valid @RequestBody FamillesFournisseursVO vO) {
        return famillesFournisseursService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        famillesFournisseursService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody FamillesFournisseursUpdateVO vO) {
        famillesFournisseursService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FamillesFournisseursDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return famillesFournisseursService.getById(id);
    }

    @GetMapping
    public Page<FamillesFournisseursDTO> query(@Valid FamillesFournisseursQueryVO vO) {
        return famillesFournisseursService.query(vO);
    }
}
