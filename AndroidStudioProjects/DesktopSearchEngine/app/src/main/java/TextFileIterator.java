import java.util.Iterator;

public class TextFileIterator implements Iterator<String> {
    public TextFileIterator(Resource res){

    }
    public boolean hasNext(){
        return true;
    }
    public String next(){
        return null;
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
    public String getAsString(Resource res){
        return "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    }
}