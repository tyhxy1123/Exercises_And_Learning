using System;

namespace CSInANutShell.Model
{
    public class FixedSizedBufferDemo
    {
        unsafe struct UnsafeUnicodeString
        {
            public short Length;
            public fixed byte Buffer[30];
        }

        unsafe public class UnsafeClass
        {
            private UnsafeUnicodeString uus;

            public UnsafeClass(string s)
            {
                uus.Length = (short) s.Length;
                fixed (byte* p = uus.Buffer)
                {
                    for (int i = 0; i < s.Length; i++)
                    {
                        p[i] = (byte)s[i];
                    }
                }
            }

            public static void Run()
            {
                var uc = new UnsafeClass("Christian Troy");
                for (var i = 0; i < uc.uus.Length; i++)
                {
                    Console.Write($"{(char)uc.uus.Buffer[i]}");
                }
            }
        }
    }
}