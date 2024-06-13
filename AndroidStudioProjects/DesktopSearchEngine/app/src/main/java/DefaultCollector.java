import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> set = new HashSet<String>();
        set.add(res.getName());
        return set;
    }
}