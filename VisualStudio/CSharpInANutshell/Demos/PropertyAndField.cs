using System;
namespace CSharpInANutshell.Demos
{
    public class PropertyAndField
    {
        string name;
        long id;

        public string Name
        {
            set => name = value;
            get => name;
        }

        public long Id {
            get => id; set => id = value;
        }

        public PropertyAndField()
        {

        }
    }
}
