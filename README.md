# Virtual-Topics
Experimenting with Jms Virtual Topics

---

Based on https://tuhrig.de/queues-vs-topics-vs-virtual-topics-in-activemq/

The detailed implementation can be found here: https://tuhrig.de/virtual-topics-in-activemq/

By playing with the properties of the 3 applications, you can test various scenarios using queues, topics and virtual-topics by checking the various logs generated.

---

### Setting up

You will need:
- Docker
- Maven

You will need to have an instance of ActiveMQ running on your machine. If you have docker installed, simply run the following command:

``docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
``

Then you can navigate in each app folder and boot the apps running:

``mvn spring-boot:run``
