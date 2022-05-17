package MusicPlayerAnnotations;

import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music {
    @Override
    public String getSong(){
        return "4 seasons";
    }

}
