package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchNoteDebitEnteteDTO;
import com.yewi.yewicore.recuperation.service.AchNoteDebitEnteteService;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteQueryVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchNoteDebitEnteteVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achNoteDebitEntete")
public class AchNoteDebitEnteteController {

    @Autowired
    private AchNoteDebitEnteteService achNoteDebitEnteteService;

    @PostMapping
    public String save(@Valid @RequestBody AchNoteDebitEnteteVO vO) {
        return achNoteDebitEnteteService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achNoteDebitEnteteService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchNoteDebitEnteteUpdateVO vO) {
        achNoteDebitEnteteService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchNoteDebitEnteteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achNoteDebitEnteteService.getById(id);
    }

    @GetMapping
    public Page<AchNoteDebitEnteteDTO> query(@Valid AchNoteDebitEnteteQueryVO vO) {
        return achNoteDebitEnteteService.query(vO);
    }
}
