import java.util.Set;

public class ResourceType implements KeywordCollector{
    private String description;
    private KeywordCollector collector;
    public ResourceType(String desc, KeywordCollector collector){
        this.description = desc;
        this.collector = collector;
    }
    public String getDescription(){
        return description;
    }
    public KeywordCollector getCollector(){
        return collector;
    }
    public Set<String> getKeywords(Resource res){
        return null;
    }
}