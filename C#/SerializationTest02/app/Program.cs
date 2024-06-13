using library;
using static System.Console;

namespace app
{
    class Program
    {
        static void Main(string[] args)
        {
            WriteLine($"The answer is {new Thing().Get(19,23)}");
        }
    }
}
