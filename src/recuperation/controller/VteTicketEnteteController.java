package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteTicketEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteTicketEnteteService;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteTicketEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteTicketEntete")
public class VteTicketEnteteController {

    @Autowired
    private VteTicketEnteteService vteTicketEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteTicketEnteteVO vO) {
        return vteTicketEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteTicketEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteTicketEnteteUpdateVO vO) {
        vteTicketEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteTicketEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteTicketEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteTicketEnteteDTO> query(@Valid VteTicketEnteteQueryVO vO) {
        return vteTicketEnteteService.query(vO);
    }
}
