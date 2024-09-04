package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.UtilisateursDTO;
import com.yewi.yewicore.recuperation.service.UtilisateursService;
import com.yewi.yewicore.recuperation.vo.UtilisateursQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateursController {

    @Autowired
    private UtilisateursService utilisateursService;

    @PostMapping
    public String save(@Valid @RequestBody UtilisateursVO vO) {
        return utilisateursService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        utilisateursService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UtilisateursUpdateVO vO) {
        utilisateursService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UtilisateursDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return utilisateursService.getById(id);
    }

    @GetMapping
    public Page<UtilisateursDTO> query(@Valid UtilisateursQueryVO vO) {
        return utilisateursService.query(vO);
    }
}
