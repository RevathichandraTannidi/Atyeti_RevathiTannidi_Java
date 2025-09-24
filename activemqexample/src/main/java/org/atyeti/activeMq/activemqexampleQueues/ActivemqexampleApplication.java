package org.atyeti.activeMq.activemqexampleQueues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqexampleApplication.class, args);
	}

}
// queues  --> point to point
//http://localhost:8080/messages?msg=HelloActiveMQ
//http://localhost:8161/admin/queues.jsp
//http://localhost:8161/admin/topics.jsp