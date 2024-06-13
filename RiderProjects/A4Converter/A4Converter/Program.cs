using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;

namespace A4Converter
{
    internal class Program
    {
        private static IEnumerable<string> ClearText(string fileName)
        {
            string[] text = File.ReadAllLines(fileName);
            foreach (var line in text)
            {
                if (!string.IsNullOrWhiteSpace(line))
                {
                    // Console.WriteLine("line: " + line);
                    yield return line;
                }
            }
        }

        private static void LineProcess(IEnumerable<string> lines, string outputName)
        {
            using (TextWriter writer = File.CreateText(outputName))
            {
                foreach (var line in lines)
                {
                    string res;
                    if (line.Replace(" ", "").All(char.IsUpper))
                    {
                        try
                        {
                            res = line.Insert(0, "<h4>")+"</h4>";
                        }
                        catch (IndexOutOfRangeException e)
                        {
                            Console.WriteLine(e);
                            throw;
                        }
                    }
                    else
                    {
                        try
                        {
                            res = line.Insert(0, "<p>")+"</p>";
                        }
                        catch (IndexOutOfRangeException e)
                        {
                            Console.WriteLine(e);
                            throw;
                        }
                    }
                    writer.WriteLine(res);
                }
            }
        }

        private static void Paging(string fileName, string outputName)
        {
            int count = 0;
            using (TextReader reader = File.OpenText(fileName))
            {
                var paged = false;
                var finished = false;
                using (TextWriter writer = File.CreateText(outputName))
                {
                    bool isStart = true;
                    while (!finished)
                    {
                        while (!paged)
                        {
                            var line = reader.ReadLine();
                            if (line == null)
                            {
                                finished = true;
                                break;
                            }

                            string tmp = line;
                            for (int i = 0; i < 2; i++)
                            {
                                if (string.IsNullOrWhiteSpace(tmp)) break;
                                int startIndex = tmp.IndexOf('<');
                                int endIndex = tmp.IndexOf('>');
                                tmp = tmp.Remove(startIndex, endIndex - startIndex+1);
                            }

                            count += tmp.Length;
                            
                            if(isStart) {
                                writer.WriteLine("<page size=\"A4\">");
                                writer.WriteLine();
                                writer.WriteLine(line);
                                isStart = false;
                            }
                            else
                            {
                                writer.WriteLine(line);
                            }
                            
                            if (count <= 4500) continue;
                            paged = true;
                            count = 0;
                        }

                        if (finished) break;
                        writer.WriteLine("</page>");
                        paged = false;
                        isStart = true;
                    }
                }
            }
        }

        private static void TemplateAssembly(string origin, string templatePath, string resultPath)
        {
            using (TextReader contentReader = File.OpenText(origin))
            using(TextReader templateReader = File.OpenText(templatePath))
            using(TextWriter writer = File.CreateText(resultPath))
            {
                var line = templateReader.ReadLine();
                while (true)
                {
                    writer.WriteLine(line);
                    if (line != null && line.StartsWith("<body>")) break;
                    line = templateReader.ReadLine();
                }
                writer.WriteLine(contentReader.ReadToEnd());
                writer.WriteLine(templateReader.ReadToEnd());
            }
            
        }
        
        public static void Main(string[] args)
        {
            string korpus = @"../../rsc/Korpus.txt";
            string result = @"../../result.html";
            string paged = @"../../finished.html";
            string finalPath = @"../../IndustrialSocietyAndItsFuture.html";
            string template = @"../../Template.html";
            LineProcess(ClearText(korpus), result);
            Paging(result, paged);
            TemplateAssembly(paged, template, finalPath);
            File.Delete(paged);
            File.Delete(result);  
        }
    }
}