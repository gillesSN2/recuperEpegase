package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.FonctionnalitesDTO;
import com.yewi.yewicore.recuperation.service.FonctionnalitesService;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesQueryVO;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.FonctionnalitesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/fonctionnalites")
public class FonctionnalitesController {

    @Autowired
    private FonctionnalitesService fonctionnalitesService;

    @PostMapping
    public String save(@Valid @RequestBody FonctionnalitesVO vO) {
        return fonctionnalitesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        fonctionnalitesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody FonctionnalitesUpdateVO vO) {
        fonctionnalitesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FonctionnalitesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return fonctionnalitesService.getById(id);
    }

    @GetMapping
    public Page<FonctionnalitesDTO> query(@Valid FonctionnalitesQueryVO vO) {
        return fonctionnalitesService.query(vO);
    }
}
