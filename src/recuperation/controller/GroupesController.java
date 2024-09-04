package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.GroupesDTO;
import com.yewi.yewicore.recuperation.service.GroupesService;
import com.yewi.yewicore.recuperation.vo.GroupesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/groupes")
public class GroupesController {

    @Autowired
    private GroupesService groupesService;

    @PostMapping
    public String save(@Valid @RequestBody GroupesVO vO) {
        return groupesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        groupesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody GroupesUpdateVO vO) {
        groupesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GroupesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return groupesService.getById(id);
    }

    @GetMapping
    public Page<GroupesDTO> query(@Valid GroupesQueryVO vO) {
        return groupesService.query(vO);
    }
}
