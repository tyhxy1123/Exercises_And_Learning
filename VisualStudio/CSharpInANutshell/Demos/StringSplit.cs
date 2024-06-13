using System;
namespace CSharpInANutshell.Demos
{
    public class StringSplit
    {
        public void Run()
        {
            string str = "hello world  !  oh.";
            string[] received = str.Split(' ');
            Array.ForEach<string>(received, Console.WriteLine);

        }
    }
}
