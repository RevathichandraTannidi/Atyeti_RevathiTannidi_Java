package org.atyeti.sihas.smartIot.repository;

import org.atyeti.sihas.smartIot.entity.AutomationRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutomationRuleRepository extends JpaRepository<AutomationRule, Long> {
    List<AutomationRule> findByEnabledTrue();
}

