package zetyun

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Created by ryan on 17-7-18.
  */
object ProducerControl {
  def main(args: Array[String]): Unit ={
    val topic = "controls"
    val props = new Properties()
    props.put("bootstrap.servers", "192.168.1.81:6667")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val message: List[String] = List("{\"customerId\":\"deadbeef-dead-beef-dead-beefdeadbeef\",\"alertId\":\"f4b9d5a5-b5d3-41e1-ae8c-2e5d357fb83e\",\"alertName\":\"Testing Alert\",\"alertDescription\":\"This is a test alert.\",\"threshold\":2,\"jsonPath\":\"$.store.book[0].author\"}", "{\"customerId\":\"deadbeef-dead-beef-dead-beefdeadbeef\",\"alertId\":\"f4b9d5a5-b5d3-41e1-ae8c-2e5d357fb83e\",\"alertName\":\"Testing Alert\",\"alertDescription\":\"This is a test alert.\",\"threshold\":2,\"jsonPath\":\"$.store.book[0].author\"}")
    for(i <- 0 to message.length - 1){
      val record = new ProducerRecord(topic, Integer.toString(i + 1), message(i))
      producer.send(record)
      println(message(i))
    }
    producer.close()
  }
}
