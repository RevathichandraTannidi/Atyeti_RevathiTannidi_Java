
import service.InventoryManager;
import service.OrderCsv;
import service.OrderReader;
import service.OrderService;
import threads.OrderWorker;
import model.Order;
import java.util.List;

public class OrderfullFill {
    public static void main(String[] args) throws InterruptedException {
        OrderReader reader = new OrderReader();
        List<Order> allOrders = reader.readOrdersFromCSV("C:\\Users\\RevathiTannidi\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_RevathiTannidi_Java\\ThReads\\threadss\\src\\main\\poc\\orderfulfillmentSystem\\csvfiles\\input_orders.csv");
         InventoryManager inventory = new InventoryManager();
        OrderService orderService = new OrderService();
         OrderCsv logger = new OrderCsv();

         int batchSize = allOrders.size() / 3;
        List<Order> batch1 = allOrders.subList(0, batchSize);
         List<Order> batch2 = allOrders.subList(batchSize, 2 * batchSize);
        List<Order> batch3 = allOrders.subList(2 * batchSize, allOrders.size());

        Thread t1 = new Thread(new OrderWorker(batch1, inventory, orderService, logger));
         Thread t2 = new Thread(new OrderWorker(batch2, inventory, orderService, logger));
        Thread t3 = new Thread(new OrderWorker(batch3, inventory, orderService, logger));

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n Final Inventory: " + inventory.getInventory());
    }
}
