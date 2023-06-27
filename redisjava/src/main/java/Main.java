import redis.clients.jedis.Jedis;

public class Main {
	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		jedis.publish("topic", "123123213");
		System.out.println("thanh cong");
		
	}
}
