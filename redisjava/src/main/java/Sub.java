import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Sub {
	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		JedisPubSub jedisPubSub = new JedisPubSub() {
		      @Override
		      public void onMessage(String channel, String message) {
		          // Handle received message
		          System.out.println("Received message: " + message);
		          
		          
		          
		      }
		  };
		  
		  // Subscribe to the "channel1" channel
		  jedis.subscribe(jedisPubSub, "topic");
	}
}
