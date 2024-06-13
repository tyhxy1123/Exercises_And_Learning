using System;
using System.Security.Cryptography.X509Certificates;
using System.Collections.Generic;
namespace ContosoUniversity.Models
{
    public class Student
    {
        public int ID { get; set; }

        public string LastName { get; set; }
        public string FirstMidName { get; set; }
        public DateTime EnrollmentData { get; set; }

        public ICollection<Enrollment> Enrollments { get; set; }
    }
}
