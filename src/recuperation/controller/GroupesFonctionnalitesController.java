package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.GroupesFonctionnalitesDTO;
import com.yewi.yewicore.recuperation.service.GroupesFonctionnalitesService;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesFonctionnalitesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/groupesFonctionnalites")
public class GroupesFonctionnalitesController {

    @Autowired
    private GroupesFonctionnalitesService groupesFonctionnalitesService;

    @PostMapping
    public String save(@Valid @RequestBody GroupesFonctionnalitesVO vO) {
        return groupesFonctionnalitesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        groupesFonctionnalitesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody GroupesFonctionnalitesUpdateVO vO) {
        groupesFonctionnalitesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GroupesFonctionnalitesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return groupesFonctionnalitesService.getById(id);
    }

    @GetMapping
    public Page<GroupesFonctionnalitesDTO> query(@Valid GroupesFonctionnalitesQueryVO vO) {
        return groupesFonctionnalitesService.query(vO);
    }
}
