import java.util.HashSet;
import java.util.Set;

public class PlainTextCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> set = new HashSet<String>();
        set.add(new TextFileIterator(res).getAsString(res));
        return set;
    }
}