using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WCUStudent.WebApi.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WCUStudent.WebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : Controller
    {
        private readonly StudentContext _context;

        public StudentController(StudentContext context)
        {
            _context = context;

            if (_context.StudentItems.Count() == 0)
            {
                // Create a new TodoItem if collection is empty,
                // which means you can't delete all TodoItems.
                _context.StudentItems.Add(new Student { Name = "Item1" });
                _context.SaveChanges();
            }
        }

        // GET: api/<controller>
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Student>>> GetStudentItems()

        {
            return await _context.StudentItems.ToListAsync();

        }

        // GET api/<controller>/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Student>> GetStudentItem(int id)
        {
            var studentItem = await _context.StudentItems.FindAsync(id);

            if (studentItem == null)
            {
                return NotFound();
            }

            return studentItem;

        }
        
        // POST api/<controller>
        [HttpPost]
        public async Task<ActionResult<Student>> PostStudentItem(Student studentItem)
        {
            _context.StudentItems.Add(studentItem);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetStudentItem", new { id = studentItem.Id }, studentItem);

        }
        
        // PUT api/<controller>/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutStudentItem(int id, Student studentItem)
        {
            if (id != studentItem.Id)
            {
                return BadRequest();
            }

            _context.Entry(studentItem).State = EntityState.Modified;
            await _context.SaveChangesAsync();

            return NoContent();

        }

        // DELETE api/<controller>/5
        [HttpDelete("{id}")]
        public async Task<ActionResult<Student>> DeleteStudentItem(int id)
        {
            var studentItem = await _context.StudentItems.FindAsync(id);
            if (studentItem == null)
            {
                return NotFound();
            }

            _context.StudentItems.Remove(studentItem);
            await _context.SaveChangesAsync();

            return studentItem;

        }
    }
}
