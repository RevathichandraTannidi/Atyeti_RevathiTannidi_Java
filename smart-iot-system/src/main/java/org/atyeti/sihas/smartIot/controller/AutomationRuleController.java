package org.atyeti.sihas.smartIot.controller;


import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.entity.AutomationRule;
import org.atyeti.sihas.smartIot.service.AutomationRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automation")
@RequiredArgsConstructor
public class AutomationRuleController {
    private final AutomationRuleService svc;

    @PostMapping
    public ResponseEntity<AutomationRule> create(@RequestBody AutomationRule rule) {
        return ResponseEntity.ok(svc.create(rule));
    }

    @GetMapping
    public ResponseEntity<List<AutomationRule>> list() {
        return ResponseEntity.ok(svc.list());
    }
}

