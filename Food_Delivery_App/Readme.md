Starts 5 delivery partner threads (each has a personal queue).

Starts an Order Producer thread that generates random orders every 1–4 seconds (you can change this).

Starts an Order Consumer thread that takes orders from a central BlockingQueue<Order> and sends them to the restaurant for preparation.

After prep, DeliveryAssignmentService finds the nearest available delivery partner and assigns the order.

Partners simulate pickup + travel based on distance & speed, then complete and become available again.

A scheduled report runs every 30 seconds printing the metrics you asked for