package org.atyeti.finance_analytical_system.model;

import org.atyeti.finance_analytical_system.model.EMICalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EMITest {

    @Test
    void testEMICalculation() {
        EMICalculator calc = new EMICalculator();
        double emi = calc.calculateEMI(500000, 10, 60);

        assertTrue(emi > 0);
    }

    @Test
    void testEMIWithZeroInterest() {
        EMICalculator calc = new EMICalculator();

        double emi = calc.calculateEMI(120000, 0, 12);

        assertEquals(10000, emi, 0.01);
    }



}