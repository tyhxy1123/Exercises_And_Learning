using System;
using System.ComponentModel.DataAnnotations;
namespace ContosoUniversity.Models
{
    public enum Grade
    {
        A, B, C, D, F
    }

    public class Enrollment
    {
        int EnrollmentID { get; set; }

        int CourseID { get; set; }
        int StudentID { get; set; }
        Grade? Grade { get; set; }

        Course Course { get; set; }
        Student Student { get; set; }

    }
}
