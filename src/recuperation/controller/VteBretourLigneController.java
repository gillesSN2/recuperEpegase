package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBretourLigneDTO;
import com.yewi.yewicore.recuperation.service.VteBretourLigneService;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBretourLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBretourLigne")
public class VteBretourLigneController {

    @Autowired
    private VteBretourLigneService vteBretourLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteBretourLigneVO vO) {
        return vteBretourLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBretourLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBretourLigneUpdateVO vO) {
        vteBretourLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBretourLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBretourLigneService.getById(id);
    }

    @GetMapping
    public Page<VteBretourLigneDTO> query(@Valid VteBretourLigneQueryVO vO) {
        return vteBretourLigneService.query(vO);
    }
}
