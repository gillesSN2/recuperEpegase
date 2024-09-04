package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteDevisLigneDTO;
import com.yewi.yewicore.recuperation.service.VteDevisLigneService;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteDevisLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteDevisLigne")
public class VteDevisLigneController {

    @Autowired
    private VteDevisLigneService vteDevisLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteDevisLigneVO vO) {
        return vteDevisLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteDevisLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteDevisLigneUpdateVO vO) {
        vteDevisLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteDevisLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteDevisLigneService.getById(id);
    }

    @GetMapping
    public Page<VteDevisLigneDTO> query(@Valid VteDevisLigneQueryVO vO) {
        return vteDevisLigneService.query(vO);
    }
}
