package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.UtilisateursFonctionnalitesesDTO;
import com.yewi.yewicore.recuperation.service.UtilisateursFonctionnalitesesService;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesQueryVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.UtilisateursFonctionnalitesesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/utilisateursFonctionnaliteses")
public class UtilisateursFonctionnalitesesController {

    @Autowired
    private UtilisateursFonctionnalitesesService utilisateursFonctionnalitesesService;

    @PostMapping
    public String save(@Valid @RequestBody UtilisateursFonctionnalitesesVO vO) {
        return utilisateursFonctionnalitesesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        utilisateursFonctionnalitesesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UtilisateursFonctionnalitesesUpdateVO vO) {
        utilisateursFonctionnalitesesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UtilisateursFonctionnalitesesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return utilisateursFonctionnalitesesService.getById(id);
    }

    @GetMapping
    public Page<UtilisateursFonctionnalitesesDTO> query(@Valid UtilisateursFonctionnalitesesQueryVO vO) {
        return utilisateursFonctionnalitesesService.query(vO);
    }
}
