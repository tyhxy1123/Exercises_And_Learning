import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index{
    private Map<String, List<Resource>> index;
    public Index(){
        index = new HashMap<String, List<Resource>>();
    }
    public void add(Resource res){

    }
    public List<Resource> getResources(String keyword){
        return index.get(keyword);
    }
}