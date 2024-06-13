using System;

namespace CSInANutShell.Model
{
    public class VoidPointer
    {
        public unsafe static void Run()
        {
            short[] a = { 1,1,2,3,5,8,13,21,34,55 };
            fixed (short* p = a)
            {
                Zap(memory: p, byteCount: a.Length * sizeof(short));
            }

            foreach (short x in a)
            {
                Console.Write($"{x} ");
            }
        }

        unsafe static void Zap(void* memory, int byteCount)
        {
            byte* b = (byte*) memory;
            for (int i = 0; i < byteCount; i++)
            {
                *b++ = 0;
            }
        }
    }
}