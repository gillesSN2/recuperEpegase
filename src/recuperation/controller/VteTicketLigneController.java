package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteTicketLigneDTO;
import com.yewi.yewicore.recuperation.service.VteTicketLigneService;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTicketLigneVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteTicketLigne")
public class VteTicketLigneController {

    @Autowired
    private VteTicketLigneService vteTicketLigneService;

    @PostMapping
    public String save(@Valid @RequestBody VteTicketLigneVO vO) {
        return vteTicketLigneService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteTicketLigneService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteTicketLigneUpdateVO vO) {
        vteTicketLigneService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteTicketLigneDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteTicketLigneService.getById(id);
    }

    @GetMapping
    public Page<VteTicketLigneDTO> query(@Valid VteTicketLigneQueryVO vO) {
        return vteTicketLigneService.query(vO);
    }
}
