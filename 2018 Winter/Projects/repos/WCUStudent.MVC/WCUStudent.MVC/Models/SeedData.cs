using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace WCUStudent.MVC.Models
{
    public static class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new WCUStudentMVCContext(
                serviceProvider.GetRequiredService<
                    DbContextOptions<WCUStudentMVCContext>>()))
            {
                // Look for any movies.
                if (context.Student.Any())
                {
                    return;   // DB has been seeded
                }

                context.Student.AddRange(
                    new Student
                    {
                        name = "Ben Walker",
                        major = "Computer Science"
                    },

                    /*
                    new Movie
                    {
                        Title = "Ghostbusters ",
                        ReleaseDate = DateTime.Parse("1984-3-13"),
                        Genre = "Comedy",
                        Price = 8.99M
                    },
                    */

                    new Student
                    {
                        name = "Evan Stilwell",
                        major = "Computer Science"
                    },

                    new Student
                    {
                        name = "Francis Convery",
                        major = "Computer Science"
                    },

                    new Student
                    {
                        name = "Nathan Quirk",
                        major = "Computer Science"
                    }
                );
                context.SaveChanges();
            }
        }

    }
}
