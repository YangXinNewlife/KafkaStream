package zetyun

import java.util.Properties

import org.apache.kafka.clients.producer._

/**
  * Created by ryan on 17-7-5.
  */
object ProduceExample extends App{
  val TOPIC = "test"
  val props = new Properties()
  props.put("bootstrap.servers", "192.168.1.81:6667")
  props.put("group.id", "test")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)
  for ( i <- 1 to 50){
      val record = new ProducerRecord(TOPIC, Integer.toString(i), s"hello $i")
      println(record)
      producer.send(record)
  }
  val record = new ProducerRecord(TOPIC, Integer.toString(100), "the end " + new java.util.Date)
  producer.send(record)
  println(record)
  producer.close()
}
