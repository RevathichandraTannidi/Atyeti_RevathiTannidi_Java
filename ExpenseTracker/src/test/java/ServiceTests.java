import com.ExpenseTracker.Service.ExpenseService;
import com.ExpenseTracker.dao.ExpenseRepository;
import com.ExpenseTracker.model.Expense;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceTests {

    @Test
    void testAddExpense_Valid() {
        ExpenseRepository repo = mock(ExpenseRepository.class);
        ExpenseService service = new ExpenseService(repo);

        Expense expense = new Expense("Lunch", 200.0, LocalDate.now());
        when(repo.save(expense)).thenReturn(expense);

        Expense saved = service.addExpense(expense);
        assertEquals(20.0, saved.getAmount());
    }

    @Test
    void testAddExpense_InvalidAmount() {
        ExpenseRepository repo = mock(ExpenseRepository.class);
        ExpenseService service = new ExpenseService(repo);

        Expense expense = new Expense("Invalid", -10.0, LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> service.addExpense(expense));
    }

    @Test
    void testGetMonthlySummary() {
        ExpenseRepository repo = mock(ExpenseRepository.class);
        ExpenseService service = new ExpenseService(repo);

        LocalDate now = LocalDate.of(2025, 8, 1);
        when(repo.findByDateBetween(any(), any())).thenReturn(Arrays.asList(
                new Expense("Groceries", 50.0, now),
                new Expense("Transport", 30.0, now)
        ));

        double summary = service.getMonthlySummary(2025, 8);
        assertEquals(80.0, summary);
    }
}


