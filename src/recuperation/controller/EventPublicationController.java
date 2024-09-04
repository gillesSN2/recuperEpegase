package recuperation.controller;

import com.yewi.yewicore.recuperation.dtos.EventPublicationDTO;
import com.yewi.yewicore.recuperation.service.EventPublicationService;
import com.yewi.yewicore.recuperation.vo.EventPublicationQueryVO;
import com.yewi.yewicore.recuperation.vo.EventPublicationUpdateVO;
import com.yewi.yewicore.recuperation.vo.EventPublicationVO;
import jakarta.persistence.NotNull;
import jakarta.persistence.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/eventPublication")
public class EventPublicationController {

    @Autowired
    private EventPublicationService eventPublicationService;

    @PostMapping
    public String save(@Valid @RequestBody EventPublicationVO vO) {
        return eventPublicationService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        eventPublicationService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody EventPublicationUpdateVO vO) {
        eventPublicationService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EventPublicationDTO getById(@Valid @NotNull @PathVariable("id") String id) {
        return eventPublicationService.getById(id);
    }

    @GetMapping
    public Page<EventPublicationDTO> query(@Valid EventPublicationQueryVO vO) {
        return eventPublicationService.query(vO);
    }
}
