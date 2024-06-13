using System;
namespace CSharpInANutshell.Demos
{
    public class RefInOut
    {
        public RefInOut()
        {
        }

        private void Swap(ref int a, ref int b)
        {
            int c = a;
            a = b;
            b = c;
        }

        private void Split(string name, out string a, out string b)
        {
            int i = name.LastIndexOf(' ');
            a = name[..i];
            b = name[(i + 1)..];
        }

        struct BigStruct
        {
            string bigName;
            long bigNumber;
        }

        private void processBigStructByRef(in BigStruct x)
        {
        }

        public void Run()
        {
            int a = 1;
            int b = 2;
            Console.WriteLine($"Before swap: a: {a}, b: {b}");
            Swap(ref a, ref b);
            Console.WriteLine($"After swap: a: {a}, b: {b}");
            string name = "Stevie Ray Vaughn";
            string firstName, lastName;
            Split(name, out firstName, out lastName);
            Console.WriteLine($"The first name is: {firstName}, last name is: {lastName}");

            //the second out parameter is discarded
            Split(name, out firstName, out _);

            
        }
    }
}
