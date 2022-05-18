package MusicPlayerNoXML;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//for createng automaticly Spring Beans
@ComponentScan("MusicPLayerNoXML")
//for injecting values
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {



}
