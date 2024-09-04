package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteContratLigneDTO;
import com.yewi.yewicore.recuperation.service.VteContratLigneService;
import com.yewi.yewicore.recuperation.vo.VteContratLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteContratLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteContratLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteContratLigne")
public class VteContratLigneController {

    @Autowired
    private VteContratLigneService vteContratLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteContratLigneVO vO) {
        return vteContratLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteContratLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteContratLigneUpdateVO vO) {
        vteContratLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteContratLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteContratLigneService.getById(id);
    }

    @GetMapping
    public Page<VteContratLigneDTO> query(@Valid VteContratLigneQueryVO vO) {
        return vteContratLigneService.query(vO);
    }
}
