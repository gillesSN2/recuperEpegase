package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.AchDocumentTraceAchatsDTO;
import com.yewi.yewicore.recuperation.service.AchDocumentTraceAchatsService;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsQueryVO;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsUpdateVO;
import com.yewi.yewicore.recuperation.vo.AchDocumentTraceAchatsVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/achDocumentTraceAchats")
public class AchDocumentTraceAchatsController {

    @Autowired
    private AchDocumentTraceAchatsService achDocumentTraceAchatsService;

    @PostMapping
    public String save(@Valid @RequestBody AchDocumentTraceAchatsVO vO) {
        return achDocumentTraceAchatsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        achDocumentTraceAchatsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AchDocumentTraceAchatsUpdateVO vO) {
        achDocumentTraceAchatsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AchDocumentTraceAchatsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return achDocumentTraceAchatsService.getById(id);
    }

    @GetMapping
    public Page<AchDocumentTraceAchatsDTO> query(@Valid AchDocumentTraceAchatsQueryVO vO) {
        return achDocumentTraceAchatsService.query(vO);
    }
}
