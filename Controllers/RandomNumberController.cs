using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace MyRandomNumber.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RandomNumberController : ControllerBase
    {
        private static readonly Random _random = new Random();

        [HttpGet]
        public ActionResult<int> GetRandomNumber()
        {
            return Ok(_random.Next(1,10));
        }
    }
}
