using System;
namespace CSharpInANutshell.Demos
{
    public class FinalizeDemo
    {
        public FinalizeDemo()
        {
            Console.WriteLine("Object instantiated...");
        }
        public void Run()
        {

        }
        ~FinalizeDemo()
        {
            Console.WriteLine("Object recollected...");
        }
    }
}
