using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace WCUStudent.MVC.Models
{
    public class WCUStudentMVCContext : DbContext
    {
        public WCUStudentMVCContext (DbContextOptions<WCUStudentMVCContext> options)
            : base(options)
        {
        }

        public DbSet<WCUStudent.MVC.Models.Student> Student { get; set; }
    }
}
