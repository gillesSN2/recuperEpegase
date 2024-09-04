package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.GroupesModulesesDTO;
import com.yewi.yewicore.recuperation.service.GroupesModulesesService;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesQueryVO;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesUpdateVO;
import com.yewi.yewicore.recuperation.vo.GroupesModulesesVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/groupesModuleses")
public class GroupesModulesesController {

    @Autowired
    private GroupesModulesesService groupesModulesesService;

    @PostMapping
    public String save(@Valid @RequestBody GroupesModulesesVO vO) {
        return groupesModulesesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        groupesModulesesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody GroupesModulesesUpdateVO vO) {
        groupesModulesesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GroupesModulesesDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return groupesModulesesService.getById(id);
    }

    @GetMapping
    public Page<GroupesModulesesDTO> query(@Valid GroupesModulesesQueryVO vO) {
        return groupesModulesesService.query(vO);
    }
}
