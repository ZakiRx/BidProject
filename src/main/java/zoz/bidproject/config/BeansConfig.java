package zoz.bidproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pusher.rest.Pusher;

@Configuration
@ComponentScan(basePackages = { "zoz.bidproject" })
public class BeansConfig {
	@Value("${PUSHER_ID}")
	private String pusherId;
	@Value("${PUSHER_KEY}")
	private String pusherKey;
	@Value("${PUSHER_SECRET}")
	private String pusherSecret;

	@Bean
	public Pusher pusher() {
		Pusher pusher = new Pusher(pusherId, pusherKey, pusherSecret);
		pusher.setCluster("eu");
		pusher.setEncrypted(true);
		return pusher;
	}
}
