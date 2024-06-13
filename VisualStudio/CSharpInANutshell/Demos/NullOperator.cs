using System;
namespace CSharpInANutshell.Demos
{
    public class NullOperator
    {
        public NullOperator()
        {
            
        }

        public void Run()
        {
            var s = "sdgogogo";
            Console.WriteLine($"s is: {s ?? "!null!"}");
            s = null;
            Console.WriteLine($"s is: {s ?? "!null!"}");

            string ss = s?.ToUpper();
            Console.WriteLine($"ss is: {ss??"!null!"}");
            ss = "not null";
            ss = ss?.ToUpper();
            Console.WriteLine($"ss is: {ss??"!null!"}");

            string ssr = ss switch
            {
                "NOT NULL" => "a",
                _ => "null"
            };
            Console.WriteLine($"ssr is: {ssr}");
            var t = ("s","ss");
            switch(t){
                case (string,string) _:
                    Console.WriteLine("you are right");
                    break;
                default:
                    Console.WriteLine("you are wrong");
                    break;
            }
        }
    }
}
