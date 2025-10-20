package org.atyeti.sihas.smartIot.service;

import lombok.RequiredArgsConstructor;
import org.atyeti.sihas.smartIot.entity.AutomationRule;
import org.atyeti.sihas.smartIot.repository.AutomationRuleRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomationRuleService {
    private final AutomationRuleRepository ruleRepo;
    private final DeviceService deviceService;
    private final NotificationService notificationService;

    public AutomationRule create(AutomationRule rule) {
        return ruleRepo.save(rule);
    }

    public List<AutomationRule> list() {
        return ruleRepo.findAll();
    }


    @Scheduled(fixedDelay = 1000)
    public void evaluateRules() {
        List<AutomationRule> rules = ruleRepo.findByEnabledTrue();
        for (AutomationRule r : rules) {
            try {

                if (r.getAction() != null && r.getAction().startsWith("device:")) {

                    notificationService.create(r.getOwnerUsername(), "Automation executed: " + r.getName());
                }
            } catch (Exception ex) {

            }
        }
    }
}
