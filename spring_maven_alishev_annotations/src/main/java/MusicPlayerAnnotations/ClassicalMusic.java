package MusicPlayerAnnotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope ("prototype")
public class ClassicalMusic implements Music {

    //methods init, destroy
    /*
    @PostConstruct
    public void doMyInit(){
        System.out.println("Doing m Initialization");
    }

    @PreDestroy
    public void doMyInit(){
        System.out.println("Doing m Initialization");
    }
    */

    @Override
    public String getSong(){
        return "4 seasons";
    }

}
