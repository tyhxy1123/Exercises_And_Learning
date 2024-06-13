using System;
namespace IKT.Kapitel1_2
{
    public class A
    {
        double[,] trans = { { 0.6, 0.38, 0.02 }, { 0.15, 0.8, 0.05 }, { 0.4, 0.6, 0 } };
        bool M_Entropie(ref double[] arr)
        {
            var length = arr.Length;
            double[] p = new double[length];
            var tmp = new double[arr.Length];
            var stationary = false;
            while (stationary)
            {
                for (var i = 0; i < length; i++)
                {
                    tmp[i] = 0;
                    for (var j = 0; j < length; j++)
                    {
                        tmp[i] += p[j] * trans[i, j];
                    }
                }
                stationary = true;
                for (var i = 0; i < length; i++)
                {
                    if (tmp[i] != arr[i]) stationary = false;
                }
            }
            return true;
        }

        public static void Run()
        {
            var input = new double[] { 0.9, 0.1, 0 };
            var a = new A();
            System.Console.WriteLine($"a: {a.M_Entropie(ref input)}");
        }

    }
}

