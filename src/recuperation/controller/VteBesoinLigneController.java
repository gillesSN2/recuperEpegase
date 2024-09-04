package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBesoinLigneDTO;
import com.yewi.yewicore.recuperation.service.VteBesoinLigneService;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBesoinLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBesoinLigne")
public class VteBesoinLigneController {

    @Autowired
    private VteBesoinLigneService vteBesoinLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteBesoinLigneVO vO) {
        return vteBesoinLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBesoinLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBesoinLigneUpdateVO vO) {
        vteBesoinLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBesoinLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBesoinLigneService.getById(id);
    }

    @GetMapping
    public Page<VteBesoinLigneDTO> query(@Valid VteBesoinLigneQueryVO vO) {
        return vteBesoinLigneService.query(vO);
    }
}
