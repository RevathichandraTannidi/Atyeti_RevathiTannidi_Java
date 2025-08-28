
import com.ExpenseTracker.Service.ExpenseService;
import com.ExpenseTracker.controller.ExpenseController;
import com.ExpenseTracker.model.Expense;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExpenseController.class)
class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpenseService service;

    @Test
    void testGetExpenses() throws Exception {
        when(service.getAllExpenses()).thenReturn(Arrays.asList(
                new Expense("Food", 100.0, LocalDate.now()),
                new Expense("Rent", 500.0, LocalDate.now())
        ));

        mockMvc.perform(get("/api/expenses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].description").value("Food"));
    }

    @Test
    void testGetSummary() throws Exception {
        when(service.getMonthlySummary(2025, 8)).thenReturn(600.0);

        mockMvc.perform(get("/api/expenses/summary/2025/8"))
                .andExpect(status().isOk())
                .andExpect(content().string("600.0"));
    }
}
