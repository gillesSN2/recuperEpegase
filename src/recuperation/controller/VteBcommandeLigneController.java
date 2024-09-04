package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteBcommandeLigneDTO;
import com.yewi.yewicore.recuperation.service.VteBcommandeLigneService;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteBcommandeLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteBcommandeLigne")
public class VteBcommandeLigneController {

    @Autowired
    private VteBcommandeLigneService vteBcommandeLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteBcommandeLigneVO vO) {
        return vteBcommandeLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteBcommandeLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteBcommandeLigneUpdateVO vO) {
        vteBcommandeLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteBcommandeLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteBcommandeLigneService.getById(id);
    }

    @GetMapping
    public Page<VteBcommandeLigneDTO> query(@Valid VteBcommandeLigneQueryVO vO) {
        return vteBcommandeLigneService.query(vO);
    }
}
