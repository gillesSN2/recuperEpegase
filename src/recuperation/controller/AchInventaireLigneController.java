package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchInventaireLigneDTO;
import com.yewi.yewicore.recuperation.service.AchInventaireLigneService;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchInventaireLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achInventaireLigne")
public class AchInventaireLigneController {

    @Autowired
    private AchInventaireLigneService achInventaireLigneService;

    @PostMapping
    public String save(@Valid @RequestBody AchInventaireLigneVO vO) {
        return achInventaireLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achInventaireLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchInventaireLigneUpdateVO vO) {
        achInventaireLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchInventaireLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achInventaireLigneService.getById(id);
    }

    @GetMapping
    public Page<AchInventaireLigneDTO> query(@Valid AchInventaireLigneQueryVO vO) {
        return achInventaireLigneService.query(vO);
    }
}
