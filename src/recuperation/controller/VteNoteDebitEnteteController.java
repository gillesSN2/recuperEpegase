package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.VteNoteDebitEnteteDTO;
import com.yewi.yewicore.recuperation.service.VteNoteDebitEnteteService;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.VteNoteDebitEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vteNoteDebitEntete")
public class VteNoteDebitEnteteController {

    @Autowired
    private VteNoteDebitEnteteService vteNoteDebitEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody VteNoteDebitEnteteVO vO) {
        return vteNoteDebitEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vteNoteDebitEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VteNoteDebitEnteteUpdateVO vO) {
        vteNoteDebitEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VteNoteDebitEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vteNoteDebitEnteteService.getById(id);
    }

    @GetMapping
    public Page<VteNoteDebitEnteteDTO> query(@Valid VteNoteDebitEnteteQueryVO vO) {
        return vteNoteDebitEnteteService.query(vO);
    }
}
