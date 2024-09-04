package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.GroupeFonctionnaliteDroitDTO;
import com.yewi.yewicore.recuperation.service.GroupeFonctionnaliteDroitService;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupeFonctionnaliteDroitVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/groupeFonctionnaliteDroit")
public class GroupeFonctionnaliteDroitController {

    @Autowired
    private GroupeFonctionnaliteDroitService groupeFonctionnaliteDroitService;

    @PostMapping
    public String save(@Valid @RequestBody GroupeFonctionnaliteDroitVO vO) {
        return groupeFonctionnaliteDroitService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        groupeFonctionnaliteDroitService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody GroupeFonctionnaliteDroitUpdateVO vO) {
        groupeFonctionnaliteDroitService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GroupeFonctionnaliteDroitDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return groupeFonctionnaliteDroitService.getById(id);
    }

    @GetMapping
    public Page<GroupeFonctionnaliteDroitDTO> query(@Valid GroupeFonctionnaliteDroitQueryVO vO) {
        return groupeFonctionnaliteDroitService.query(vO);
    }
}
