package zetyun

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

/**
  * Created by ryan on 17-7-18.
  */
object ProducerEvent {
  def main(args: Array[String]): Unit ={
    val topic = "events"
    val props = new Properties()
    props.put("bootstrap.servers", "192.168.1.81:6667")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val message: List[String] = List("{\"customerId\":\"9f20f8a4-d8c8-4a74-ac90-3452b97c2e34\",\"payload\":\"{\\\"store\\\": {\\\"book\\\": [{\\\"category\\\": \\\"reference\\\",\\\"author\\\": \\\"Nigel Rees\\\",\\\"title\\\": \\\"Sayings of the Century\\\",\\\"price\\\": 8.95},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"Evelyn Waugh\\\",\\\"title\\\": \\\"Sword of Honour\\\",\\\"price\\\": 12.99},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"Herman Melville\\\",\\\"title\\\": \\\"Moby Dick\\\",\\\"isbn\\\": \\\"0-553-21311-3\\\",\\\"price\\\": 8.99},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"J. R. R. Tolkien\\\",\\\"title\\\": \\\"The Lord of the Rings\\\",\\\"isbn\\\": \\\"0-395-19395-8\\\",\\\"price\\\": 22.99}],\\\"bicycle\\\": {\\\"color\\\": \\\"red\\\",\\\"price\\\": 19.95}},\\\"expensive\\\": 10}\"}", "{\"customerId\":\"9f20f8a4-d8c8-4a74-ac90-3452b97c2e34\",\"payload\":\"{\\\"store\\\": {\\\"book\\\": [{\\\"category\\\": \\\"reference\\\",\\\"author\\\": \\\"Nigel Rees\\\",\\\"title\\\": \\\"Sayings of the Century\\\",\\\"price\\\": 8.95},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"Evelyn Waugh\\\",\\\"title\\\": \\\"Sword of Honour\\\",\\\"price\\\": 12.99},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"Herman Melville\\\",\\\"title\\\": \\\"Moby Dick\\\",\\\"isbn\\\": \\\"0-553-21311-3\\\",\\\"price\\\": 8.99},{\\\"category\\\": \\\"fiction\\\",\\\"author\\\": \\\"J. R. R. Tolkien\\\",\\\"title\\\": \\\"The Lord of the Rings\\\",\\\"isbn\\\": \\\"0-395-19395-8\\\",\\\"price\\\": 22.99}],\\\"bicycle\\\": {\\\"color\\\": \\\"red\\\",\\\"price\\\": 19.95}},\\\"expensive\\\": 10}\"}")
    for (i <- 0 to message.length - 1){
      val record = new ProducerRecord(topic, Integer.toString(i + 1), message(i))
      producer.send(record)
      println(message(i))
    }
    producer.close()
  }
}
