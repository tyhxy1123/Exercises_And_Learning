import java.io.File
import java.util.*

fun main(args: Array<String>){
    val rules = TreeMap<String,Pair<String,String>>()
    val lexicon = TreeMap<String,String>()
    val file1 = File("rules")
    val file2 = File("lexicon")
    File("CFG.txt").forEachLine {
        var s = it.split(" ","->")
        s = s.filter(){e->e!=""}
        if(s.size < 3){
            lexicon[s[0]]=s[1]
        }
        else{
            rules[s[0]]=Pair(s[1],s[2])
        }
    }
    file1.createNewFile()
    file1.printWriter().use{out->
        rules.forEach{
            out.print(it.key + " " + it.value.first + " " + it.value.second + "\n")
        }
    }
    file2.createNewFile()
    file2.printWriter().use{out->
        lexicon.forEach{
            out.print(it.key + " " + it.value + "\n")
        }
    }
}